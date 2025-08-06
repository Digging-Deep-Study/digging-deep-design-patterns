package ch14.mediator;

public interface ChatRoomMediator {
    void enter(User... users);
    void enter(User user);
    void leave(User user);
    void send(User user, String message);
}
