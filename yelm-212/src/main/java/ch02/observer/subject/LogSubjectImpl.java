package ch02.observer.subject;

import ch02.observer.logevent.LogEvent;
import ch02.observer.observers.LogObserver;

import java.util.ArrayList;
import java.util.List;

public class LogSubjectImpl implements LogSubject {
    private final List<LogObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(LogObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(LogObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(LogEvent event) {
        observers.forEach(observer -> observer.onLogEvent(event));
    }
}
