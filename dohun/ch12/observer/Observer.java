package ch12.observer;

import ch12.state.State;

public interface Observer {
    void update(State state);
}
