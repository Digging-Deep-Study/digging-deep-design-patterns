package ch02.observer.logevent;

import java.time.LocalDateTime;

public record LogEvent(
    LogLevel level, 
    String message, 
    LocalDateTime timestamp,
    String threadName,
    String className, 
    String methodName,
    int lineNumber,
    Throwable throwable) {

    public static LogEvent info(String message, String className, String methodName, int lineNumber) {
        return new LogEvent(LogLevel.INFO, message, LocalDateTime.now(), 
        Thread.currentThread().getName(), className, methodName, lineNumber, null);
    }

    public static LogEvent debug(String message, String className, String methodName, int lineNumber) {
        return new LogEvent(LogLevel.DEBUG, message, LocalDateTime.now(), Thread.currentThread().getName(), className, methodName, lineNumber, null);
    }

    public static LogEvent warning(String message, String className, String methodName, int lineNumber) {
        return new LogEvent(LogLevel.WARNING, message, LocalDateTime.now(), Thread.currentThread().getName(), className, methodName, lineNumber, null);
    }

    public static LogEvent error(String message, String className, String methodName, int lineNumber, Throwable throwable) {
        return new LogEvent(LogLevel.ERROR, message, LocalDateTime.now(), Thread.currentThread().getName(), className, methodName, lineNumber, throwable);
    }

    @Override
    public String toString() {
        return LogLevel.valueOf(this.level.name()).name() + ": " + this.message
                + " at " + this.timestamp + " (" + this.threadName + ")"
                + " (" + this.className + ")"
                + " (" + this.methodName + ")"
                + " (" + this.lineNumber + ")"
                + "\n";
    }
}
