import java.util.Arrays;
import java.util.List;
class ArrayList {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Go", "Python", "React", "Java");
        names.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println(names);
    }
}