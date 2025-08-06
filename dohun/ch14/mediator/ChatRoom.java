package ch14.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatRoomMediator {
    private final List<User> users = new ArrayList<>();

    @Override
    public void enter(User... users) {
        for (User user : users) {
            enter(user);
        }
    }

    @Override
    public void enter(User user) {
        System.out.println(user.getName() + " 님이 입장하셨습니다.");
        users.add(user);
    }

    @Override
    public void leave(User user) {
        System.out.println(user.getName() + " 님이 퇴장하셨습니다.");
        users.remove(user);
    }

    @Override
    public void send(User user, String message) {
        System.out.println("[" + user.getName() + "] " + message);
    }
}
