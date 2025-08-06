package ch14.mediator;

public class ChatApp {
    public static void main(String[] args) {

        ChatRoom chatRoom = new ChatRoom();

        User user1 = new ChatUser(chatRoom, "user1");
        User user2 = new ChatUser(chatRoom, "user2");
        User user3 = new ChatUser(chatRoom, "user3");

        chatRoom.enter(user1, user2, user3);

        user1.send("Hello world!");
        user2.send("wow");

        chatRoom.leave(user3);
    }
}