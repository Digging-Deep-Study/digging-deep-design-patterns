package ch06.command;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("잘못된 명령어입니다.");
    }
}
