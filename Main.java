import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // NotificationService service = new EmailService();
        // service.sendWithRetry("Hello", 3);
        /*
         * String input = "Hello";
         * boolean lengthGreaterThan5 = StringValidationUtil.validate(input, (value) ->
         * value.length() > 5);
         * System.out.println("Length > 5: " + lengthGreaterThan5);
         * 
         * boolean startsWithH = StringValidationUtil.validate(input, (value) ->
         * value.startsWith("H"));
         * System.out.println("Starts with H: " + startsWithH);
         */
        List<User> users = Arrays.asList(
                new User("Ansh", 22),
                new User("Aman", 20),
                new User("Ravi", 21),
                new User("Rahul", 23));
        List<String> result = users.stream().filter(user -> user.getage() > 21).map(user -> user.getname())
                .collect(Collectors.toList());
        System.out.println(result);
    }
}