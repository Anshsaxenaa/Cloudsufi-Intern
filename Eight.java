public class Eight {
    public static void main(String[] args) {
        String userId = "101";

        String Query = """
                SELECT id, username,email,created_at
                FROM users
                WHERE id = '%s'
                ORDER BY created_at DESC
                """.formatted(userId);
        System.out.println(Query);
    }

}
