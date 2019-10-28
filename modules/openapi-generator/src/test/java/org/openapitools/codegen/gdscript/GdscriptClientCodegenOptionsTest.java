package org.openapitools.codegen.gdscript;

import org.openapitools.codegen.AbstractOptionsTest;
import org.openapitools.codegen.CodegenConfig;
import org.openapitools.codegen.languages.GdscriptClientCodegen;
import org.openapitools.codegen.options.GdscriptClientCodegenOptionsProvider;

import mockit.Expectations;
import mockit.Tested;

public class GdscriptClientCodegenOptionsTest extends AbstractOptionsTest {

    @Tested
    private GdscriptClientCodegen codegen;

    public GdscriptClientCodegenOptionsTest() {
        super(new GdscriptClientCodegenOptionsProvider());
    }

    @Override
    protected CodegenConfig getCodegenConfig() {
        return codegen;
    }

    @SuppressWarnings("unused")
    @Override
    protected void setExpectations() {
        // TODO: Complete options
        new Expectations(codegen) {{

        }};
    }
}

