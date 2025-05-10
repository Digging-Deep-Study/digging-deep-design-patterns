package com.practice.chapter;

import java.util.List;

public class ObserverPattern {
    private static final LogObserver consoleObserver =
            (level, message) -> System.out.println("[" + level.name() + "] Console: " + message);
    private static final LogObserver fileObserver =
            (level, message) -> System.out.println("[" + level.name() + "] File: " + message);

    public static void main(String[] args) {
        LogPublisher logPublisher = new LogPublisher();

        logPublisher.registerObserver(consoleObserver);
        logPublisher.registerObserver(fileObserver);

        logPublisher.publishError("An error occurred");
        logPublisher.publishWarn("This is a warning");
        logPublisher.publishInfo("Informational message");
    }

    enum LogLevel {
        INFO, WARNING, ERROR
    }

    @FunctionalInterface
    interface LogObserver {
        void onLog(LogLevel level, String message);
    }

    static class LogPublisher {
        private final List<LogObserver> observer = new java.util.ArrayList<>();

        public void registerObserver(LogObserver observer) {
            this.observer.add(observer);
        }

        public void unregisterObserver(LogObserver observer) {
            this.observer.remove(observer);
        }

        public void publishError(String message) {
            publish(LogLevel.ERROR, message);
        }

        public void publishWarn(String message) {
            publish(LogLevel.WARNING, message);
        }

        public void publishInfo(String message) {
            publish(LogLevel.INFO, message);
        }

        public void publish(LogLevel level, String message) {
            for (LogObserver observer : observer) {
                observer.onLog(level, message);
            }
        }
    }
}
