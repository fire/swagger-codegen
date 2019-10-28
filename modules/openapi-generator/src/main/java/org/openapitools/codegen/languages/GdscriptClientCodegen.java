package org.openapitools.codegen.languages;

import org.openapitools.codegen.*;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.MapProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.parameters.Parameter;

import java.io.File;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GdscriptClientCodegen extends DefaultCodegen implements CodegenConfig {
    public static final String PROJECT_NAME = "projectName";
    public static final String PACKAGE_URL = "packageUrl";

    protected String packageName; // e.g. petstore_api

    static Logger LOGGER = LoggerFactory.getLogger(GdscriptClientCodegen.class);

    protected Map<Character, String> regexModifiers;

    public CodegenType getTag() {
        return CodegenType.CLIENT;
    }

    public String getName() {
        return "gdscript";
    }

    public String getHelp() {
        return "Generates a gdscript client.";
    }

    public GdscriptClientCodegen() {
        super();

        outputFolder = "generated-code" + File.separator + "gdscript";
        modelTemplateFiles.put("model.mustache", ".gd.inc");
        apiTemplateFiles.put("api.mustache", ".gd");
        apiTemplateFiles.put("api_doc.mustache", ".md");
        embeddedTemplateDir = templateDir = "gdscript-client";
        apiPackage = File.separator + "Apis";
        modelPackage = File.separator + "Models";
        supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));
        
        languageSpecificPrimitives.clear();
        languageSpecificPrimitives.add("int");
        languageSpecificPrimitives.add("float");
        languageSpecificPrimitives.add("List");
        languageSpecificPrimitives.add("Dictionary");
        languageSpecificPrimitives.add("bool");
        languageSpecificPrimitives.add("String");
        languageSpecificPrimitives.add("datetime");
        languageSpecificPrimitives.add("date");
        languageSpecificPrimitives.add("object");


        instantiationTypes.put("map", "dict");

        typeMapping.clear();
        typeMapping.put("integer", "int");
        typeMapping.put("float", "float");
        typeMapping.put("number", "float");
        typeMapping.put("long", "int");
        typeMapping.put("double", "float");
        typeMapping.put("array", "List");
        typeMapping.put("map", "Dictionary");
        typeMapping.put("boolean", "bool");
        typeMapping.put("string", "String");
        typeMapping.put("date", "date");
        typeMapping.put("DateTime", "datetime");
        typeMapping.put("object", "Object");
        typeMapping.put("file", "file");
        // TODO binary should be mapped to byte array
        // mapped to String as a workaround
        typeMapping.put("binary", "str");
        typeMapping.put("ByteArray", "str");
        // map uuid to string for the time being
        typeMapping.put("UUID", "str");

        // from https://godot.readthedocs.io/en/3.0/getting_started/scripting/gdscript/gdscript_basics.html#keywords
        setReservedWordsLowerCase(
                Arrays.asList(
                    "Empty",
                    "Identifier",
                    "Constant",
                    "Self",
                    "Built-In Type",
                    "Built-In Func",
                    "In",
                    //
                    "if",
                    "elif",
                    "else",
                    "for",
                    "do",
                    "while",
                    "switch (reserved)",
                    "case (reserved)",
                    "break",
                    "continue",
                    "pass",
                    "return",
                    "match",
                    "func",
                    "class",
                    "class_name",
                    "extends",
                    "is",
                    "onready",
                    "tool",
                    "static",
                    "export",
                    "setget",
                    "const",
                    "var",
                    "as",
                    "void",
                    "enum",
                    "preload",
                    "assert",
                    "yield",
                    "signal",
                    "breakpoint",
                    "rpc",
                    "sync",
                    "master",
                    "puppet",
                    "slave",
                    "remotesync",
                    "mastersync",
                    "puppetsync",
                    //
                    "PI",
                    "TAU",
                    "_",
                    "INF",
                    "NAN",
                    "Error",
                    "EOF",
                    "Cursor"
                )
        );

        regexModifiers = new HashMap<Character, String>();
        regexModifiers.put('i', "IGNORECASE");
        regexModifiers.put('l', "LOCALE");
        regexModifiers.put('m', "MULTILINE");
        regexModifiers.put('s', "DOTALL");
        regexModifiers.put('u', "UNICODE");
        regexModifiers.put('x', "VERBOSE");

        cliOptions.clear();
        cliOptions.add(new CliOption(CodegenConstants.PACKAGE_NAME, "gdscript package name (convention: snake_case).")
                .defaultValue("swgclient"));
        cliOptions.add(new CliOption(CodegenConstants.PROJECT_NAME, "gdscript project name in setup.gd (e.g. petstore-api)."));
        cliOptions.add(new CliOption(CodegenConstants.PACKAGE_VERSION, "gdscript package version.")
                .defaultValue("1.0.0"));
        cliOptions.add(new CliOption(PACKAGE_URL, "gdscript package URL."));
        cliOptions.add(CliOption.newBoolean(CodegenConstants.SORT_PARAMS_BY_REQUIRED_FLAG,
                CodegenConstants.SORT_PARAMS_BY_REQUIRED_FLAG_DESC).defaultValue(Boolean.TRUE.toString()));
        cliOptions.add(new CliOption(CodegenConstants.HIDE_GENERATION_TIMESTAMP, CodegenConstants.HIDE_GENERATION_TIMESTAMP_DESC)
                .defaultValue(Boolean.TRUE.toString()));
    }

    @Override
    public void setParameterExampleValue(CodegenParameter p) {
        String example;

        if (p.defaultValue == null) {
            example = p.example;
        } else {
            example = p.defaultValue;
        }

        String type = p.baseType;
        if (type == null) {
            type = p.dataType;
        }

        if ("String".equalsIgnoreCase(type) || "str".equalsIgnoreCase(type)) {
            if (example == null) {
                example = p.paramName + "_example";
            }
            example = "'" + escapeText(example) + "'";
        } else if ("Integer".equals(type) || "int".equals(type)) {
            if (example == null) {
                example = "56";
            }
        } else if ("Float".equalsIgnoreCase(type) || "Double".equalsIgnoreCase(type)) {
            if (example == null) {
                example = "3.4";
            }
        } else if ("BOOLEAN".equalsIgnoreCase(type) || "bool".equalsIgnoreCase(type)) {
            if (example == null) {
                example = "True";
            }
        } else if ("file".equalsIgnoreCase(type)) {
            if (example == null) {
                example = "/path/to/file";
            }
            example = "'" + escapeText(example) + "'";
        } else if ("Date".equalsIgnoreCase(type)) {
            if (example == null) {
                example = "2013-10-20";
            }
            example = "'" + escapeText(example) + "'";
        } else if ("DateTime".equalsIgnoreCase(type)) {
            if (example == null) {
                example = "2013-10-20T19:20:30+01:00";
            }
            example = "'" + escapeText(example) + "'";
        } else if (!languageSpecificPrimitives.contains(type)) {
            // type is a model class, e.g. User
            example = this.packageName + "." + type + "()";
        } else {
            LOGGER.warn("Type " + type + " not handled properly in setParameterExampleValue");
        }

        if (example == null) {
            example = "NULL";
        } else if (Boolean.TRUE.equals(p.isListContainer)) {
            example = "[" + example + "]";
        } else if (Boolean.TRUE.equals(p.isMapContainer)) {
            example = "{'key': " + example + "}";
        }

        p.example = example;
    }

    @Override
    public String sanitizeTag(String tag) { return sanitizeName(tag); }

    @Override
    public String escapeQuotationMark(String input) {
        // remove ' to avoid code injection
        return input.replace("'", "");
    }

    @Override
    public String escapeUnsafeCharacters(String input) {
        // remove multiline comment
        return input.replace("'''", "'_'_'");
    }
}
