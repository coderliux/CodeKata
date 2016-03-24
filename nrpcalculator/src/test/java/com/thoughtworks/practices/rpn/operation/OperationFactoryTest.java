package com.thoughtworks.practices.rpn.operation;

import com.thoughtworks.practices.rpn.operation.impl.Unsupported;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

public class OperationFactoryTest {

    @Test
    public void testBuildOperation() throws Exception {
        Operation operation = OperationFactory.buildOperation("unsupported");
        assertThat(operation, IsInstanceOf.instanceOf(Unsupported.class));
        operation = OperationFactory.buildOperation("+");
        assertThat(operation, is(OperationFactory.SUPPORTED_OPERATION.get("+")));
    }

    @Test
    public void testIsSupportedOperation() throws Exception {
        assertThat(OperationFactory.isSupportedOperation("+"), is(true));
        assertThat(OperationFactory.isSupportedOperation("undo"), is(true));
        assertThat(OperationFactory.isSupportedOperation("+#"), is(false));
    }
}