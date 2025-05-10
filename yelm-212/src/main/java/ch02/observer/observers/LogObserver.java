package ch02.observer.observers;

import ch02.observer.logevent.LogEvent;

public interface LogObserver {
    void onLogEvent(LogEvent event);
}

