package ch12.observer;

import ch12.state.State;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(State state);
}
