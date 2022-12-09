package hexlet.code;

public final class StringSchema extends Schema {
    private Validator validator;

    public StringSchema() {}
    public StringSchema(String pattern) {
        super.setPattern(pattern);
    }

    public void required() {
        super.setRequired(true);
    }

    public void minLength(final int length) {
        super.setMinLength(length);
    }

    public StringSchema contains(final String pattern) {
        return new StringSchema(pattern);
    }
}
