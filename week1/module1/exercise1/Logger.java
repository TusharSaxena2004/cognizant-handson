public  class Logger {
    // 1. Private static instance of the class
    private static Logger instance;

    // 2. Private constructor to prevent instantiation from outside
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // 3. Public static method to get the instance (Thread-safe lazy initialization)
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // A simple method to demonstrate logging
    public void log(String message) {
        System.out.println("Log entry: " + message);
    }
}