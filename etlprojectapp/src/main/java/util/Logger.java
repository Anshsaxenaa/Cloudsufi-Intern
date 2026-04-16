package util;

import java.time.LocalDateTime;

public class Logger {

    public static void info(String message) {
        System.out.println("INFO: " + LocalDateTime.now() + " " + message);
    }

    public static void error(String message) {
        System.out.println("ERROR: " + LocalDateTime.now() + " " + message);
    }

    public static void warn(String message) {
        System.out.println("WARN: " + LocalDateTime.now() + " " + message);
    }
}
