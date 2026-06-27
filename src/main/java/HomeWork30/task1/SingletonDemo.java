package HomeWork30.task1;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public class SingletonDemo {
    public static void main(String[] args) {
        Logger firstLogger = Logger.getInstance();
        Logger secondLogger = Logger.getInstance();

        firstLogger.log("Application started");
        secondLogger.log("User opened settings");

        System.out.println("Same logger object: " + (firstLogger == secondLogger));
    }
}

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class Logger {
    private static volatile Logger instance;

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
