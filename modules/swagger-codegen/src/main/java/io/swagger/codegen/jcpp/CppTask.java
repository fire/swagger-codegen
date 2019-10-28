/*
 * Anarres C Preprocessor
 * Copyright (c) 2007-2015, Shevek
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package io.swagger.codegen.jcpp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copy Task for jcpp.
 */
public class CppTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(CppTask.class);

    public static class Macro {

        private String name;
        private String value;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private final List<Macro> macros = new ArrayList<Macro>();
    private ArrayList<String> systemincludepath =  new ArrayList<String>();
    private ArrayList<String> localincludepath =  new ArrayList<String>();

    public void addMacro(Macro macro) {
        macros.add(macro);
    }

    public void addSystemincludepath(String path) {
        systemincludepath.add(path);
    }

    public void addLocalincludepath(String path) {
        localincludepath.add(path);
    }

    private void preprocess(File input, File output) throws Exception {
        if (input == null)
            throw new IllegalArgumentException("Input not specified");
        if (output == null)
            throw new IllegalArgumentException("Output not specified");

        Preprocessor cpp = new Preprocessor();
        for (Macro macro : macros)
            cpp.addMacro(macro.getName(), macro.getValue());
        if (systemincludepath != null)
            cpp.setSystemIncludePath(systemincludepath);
        if (localincludepath != null)
            cpp.setQuoteIncludePath(localincludepath);

        File dir = output.getParentFile();
        if (!dir.exists()) {
            if (!dir.mkdirs())
                throw new IllegalArgumentException("Failed to make parent directory " + dir);
        } else if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Parent directory of output file " + output + " exists, but is not a directory.");
        }
        FileWriter writer = null;
        try {
            cpp.addInput(input);
            writer = new FileWriter(output);
            for (;;) {
                Token tok = cpp.token();
                if (tok == null)
                    break;
                if (tok.getType() == Token.EOF)
                    break;
                writer.write(tok.getText());
            }
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public void operations(Hashtable fileCopyMap, File destDir) {
        if (fileCopyMap.size() > 0) {
            LOGGER.info("Copying " + fileCopyMap.size()
                    + " file" + (fileCopyMap.size() == 1 ? "" : "s")
                    + " to " + destDir.getAbsolutePath());

            Enumeration<String> e = fileCopyMap.keys();

            while (e.hasMoreElements()) {
                String fromFile = e.nextElement();
                String[] toFiles = (String[]) fileCopyMap.get(fromFile);

                for (String toFile : toFiles) {
                    if (fromFile.equals(toFile)) {
                        LOGGER.info("Skipping self-copy of " + fromFile);
                        continue;
                    }

                    try {
                        LOGGER.info("Copying " + fromFile + " to " + toFile);

                        File srcFile = new File(fromFile);
                        File dstFile = new File(toFile);
                        preprocess(srcFile, dstFile);
                    } catch (Exception ioe) {
                        // ioe.printStackTrace();
                        String msg = "Failed to copy " + fromFile + " to " + toFile
                                + " due to " + ioe.getMessage();
                        File targetFile = new File(toFile);
                        if (targetFile.exists() && !targetFile.delete()) {
                            msg += " and I couldn't delete the corrupt " + toFile;
                        }
                        throw new IllegalArgumentException(msg);
                    }
                }
            }
        }

    }

}
