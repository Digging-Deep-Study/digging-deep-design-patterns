package ch02.observer.observers;

import ch02.observer.logevent.LogEvent;

public class ConsoleLogObserver implements LogObserver {
    @Override
    public void onLogEvent(LogEvent event) {
        System.out.println(event.toString());
    }
}