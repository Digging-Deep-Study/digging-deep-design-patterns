package ch06.command;

public class PasteCommand implements Command {
    public void execute() {
        System.out.println("Paste command");
    }

    public void undo() {
        System.out.println("Undo Paste command");
    }

    public void redo() {
        System.out.println("Redo Paste command");
    }
}
