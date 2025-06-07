package ch06.command;

public class CutCommand implements Command {
    public void execute() {
        System.out.println("Cut command");
    }

    public void undo() {
        System.out.println("Undo Cut command");
    }

    public void redo() {
        System.out.println("Redo Cut command");
    }
}
