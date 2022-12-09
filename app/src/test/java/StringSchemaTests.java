import hexlet.code.StringSchema;
import hexlet.code.Validator;
import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTests {
    @Test
    public void testRequiredValidatorWithoutRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        String string = null;
        assertTrue(schema.isValid(string));
    }

    @Test
    public void testRequiredValidatorWithRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        String string = null;
        assertFalse(schema.isValid(string));
    }

    @Test
    public void testRequiredValidatorOnWord() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        String string = "Test";
        assertTrue(schema.isValid(string));
    }

    @Test
    public void testMinLengthWhenWordIsShorter() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.minLength(5);
        String string = "Test";
        assertFalse(schema.isValid(string));
    }

    @Test
    public void testMinLengthWhenWordIsLonger() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.minLength(5);
        String string = "Long Test";
        assertTrue(schema.isValid(string));
    }

    @Test
    public void testMinLengthWhenWordIsEqual() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.minLength(5);
        String string = "Test1";
        assertTrue(schema.isValid(string));
    }

    @Test
    public void testContainsWhenPatternIsIn() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.contains("Te");
        String string = "Test";
        assertTrue(schema.isValid(string));
    }

    @Test
    public void testContainsWhenPatternIsNotIn() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.contains("eT");
        String string = "Test";
        assertFalse(schema.isValid(string));
    }

    @Test
    public void testContainsChainedCase() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        String string = "Test";
        assertTrue(schema.contains("Te").isValid(string));
    }
}
