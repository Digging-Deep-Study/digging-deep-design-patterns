package ch02.observer;

import ch02.observer.subject.LogSubject;
import ch02.observer.subject.LogSubjectImpl;
import ch02.observer.observers.LogObserver;
import ch02.observer.observers.FileLogObserver;
import ch02.observer.observers.ConsoleLogObserver;
import ch02.observer.logevent.LogEvent;

public class Main {
    public static void main(String[] args) {

        LogSubject logSubject = new LogSubjectImpl();
        LogObserver fileLogObserver = new FileLogObserver();
        LogObserver consoleLogObserver = new ConsoleLogObserver();

        logSubject.addObserver(fileLogObserver);
        logSubject.addObserver(consoleLogObserver);

        logSubject.notifyObservers(LogEvent.info("Hello, World!", "Main", "main", 20));
        logSubject.notifyObservers(LogEvent.debug("Hello, World!", "Main", "main", 21));
        logSubject.notifyObservers(LogEvent.warning("Hello, World!", "Main", "main", 22));
        logSubject.notifyObservers(LogEvent.error("Hello, World!", "Main", "main", 23, new Exception("test")));
        
        logSubject.removeObserver(fileLogObserver);
    }
}
