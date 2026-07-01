public class Main {
    public static void main(String[] args) {
        // Attempt to get two instances of the Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use the loggers
        logger1.log("Application started.");
        logger2.log("Processing data...");

        // Verify that both variables reference the exact same object in memory
        if (logger1 == logger2) {
            System.out.println("Test Passed: logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Test Failed: Multiple instances were created.");
        }
    }
}