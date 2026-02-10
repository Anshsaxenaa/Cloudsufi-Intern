import java.util.Optional;

public class Fifth {
    String username;
    boolean active;

    public Fifth(String username, boolean active) {
        this.username = username;
        this.active = active;
    }

    public String getusername() {
        return username;
    }

    public boolean getactive() {
        return active;
    }

    public static void main(String[] args) {
        findUser("101")
                .filter(Fifth::getactive)
                .map(Fifth::getusername)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("User not found"));
    }

    public static Optional<Fifth> findUser(String id) {

        if ("101".equals(id)) {
            return Optional.of(new Fifth("AnshSaxena", true));
        }
        return Optional.empty();
    }
}
