package ch06;

import ch06.command.*;

public class Main {
    public static void main(String[] args) {
        CommandControll commandControll = new CommandControll();
        commandControll.addCommand(new CutCommand());
        commandControll.addCommand(new PasteCommand());
        commandControll.undo();
        commandControll.redo();
        commandControll.undo();

//      커맨드 컨드롤러에 이전 커맨드 없으면 메시지 출력
        commandControll.undo();
        commandControll.undo();

//      커맨드 컨드롤러에 다음 커맨드 없으면 메시지 출력
        commandControll.redo();
        commandControll.redo();
        commandControll.redo();

//      커맨드 컨드롤러에 커맨드를 추가하지 않고 실행하면 예외 발생
//      commandControll.addCommand(null);
    }
}
