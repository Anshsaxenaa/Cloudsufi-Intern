import java.util.*;
import java.util.function.Predicate;

public class Fourth {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-4, -2, -1, 0, 1, 2, 3, 4, 5, 7, 10, 15, 20);
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositiveAndEven = isPositive.and(isEven);
        numbers.stream().filter(isPositiveAndEven).forEach(n -> System.out.println(n));
    }
}
