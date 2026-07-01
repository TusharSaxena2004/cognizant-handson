import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.ConsoleAppender;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    public static void main(String[] args) {
        // 1. Get the LoggerContext
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        // 2. Set up the pattern (Timestamp, Thread, Level, Logger, Message)
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(context);
        encoder.setPattern("%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
        encoder.start();

        // 3. Set up the Console Appender
        ConsoleAppender appender = new ConsoleAppender();
        appender.setContext(context);
        appender.setEncoder(encoder);
        appender.start();

        // 4. Apply configuration to our specific logger
        Logger logger = context.getLogger(LoggingExample.class);
        logger.addAppender(appender);
        logger.setLevel(Level.DEBUG);
        logger.setAdditive(false); // Prevents double-logging

        // 5. Test the logs
        logger.error("This is a formatted error message");
        logger.warn("This is a formatted warning message");
    }
}