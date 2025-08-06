package ch14.mediator;

public class ChatUser extends User {

    public ChatUser(ChatRoomMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        mediator.send(this, message);
    }
}
