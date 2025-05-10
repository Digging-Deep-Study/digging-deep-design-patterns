package ch02.observer.subject;

import ch02.observer.logevent.LogEvent;
import ch02.observer.observers.LogObserver;

public interface LogSubject {
    void addObserver(LogObserver observer);
    void removeObserver(LogObserver observer);
    void notifyObservers(LogEvent event);
}
