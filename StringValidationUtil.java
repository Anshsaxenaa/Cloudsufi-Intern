public class StringValidationUtil {
    public static boolean validate(String value, StringValidator validator) {
        return validator.validate(value);
    }

}