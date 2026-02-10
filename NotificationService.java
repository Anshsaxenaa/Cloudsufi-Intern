interface NotificationService {
    void send(String message);

    default void sendWithRetry(String message, int retries) {
        int attempt = 0;
        while (attempt <= retries) {
            try {
                send(message);
                return;
            } catch (Exception e) {
                attempt++;
                if (attempt > retries) {
                    throw new RuntimeException("Failed to send notification after retries");
                }
                System.out.println("Retrying Attempt " + attempt);
            }

        }
    }
}
