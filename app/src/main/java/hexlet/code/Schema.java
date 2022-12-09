package hexlet.code;

public abstract class Schema {
    private static boolean required = false;
    private static int minLength = -1;
    private static String pattern;


    public boolean isValid(Object obj) {
        boolean isEmpty = false;

        if (obj == null) {
            isEmpty = true;
        } else if (obj.getClass() == String.class && ((String) obj).isEmpty()) {
            isEmpty = true;
        }

        if (required && isEmpty) {
            return false;
        }

        if (minLength >= 0) {
            return ((String) obj).length() >= minLength;
        }

        if (pattern != null) {
            return ((String) obj).contains(pattern);
        }

        return true;
    }

    public final void setRequired(boolean isRequired) {
        required = isRequired;
    }

    public final boolean isRequired() {
        return required;
    }

    public final void setMinLength(final int length) {
        minLength = length;
    }

    public final int getMinLength() {
        return minLength;
    }

    public final void setPattern(final String string) {
        pattern = string;
    }

    public final String getPattern() {
        return pattern;
    }

}
