package ch06.command;

import java.util.Stack;

public class CommandControll {
    Stack<Command> prev;
    Stack<Command> next;
    public CommandControll() {
        prev = new Stack<>();
        next = new Stack<>();
    }
    public void addCommand(Command command) {
        if (command == null) {
            throw new IllegalArgumentException("Command cannot be null");
        }
        prev.push(command);
        next.clear();
    }

    public void undo() {
        if (prev.isEmpty()) {
            System.out.println("No previous command");
            return;
        }
        Command command = prev.pop();
        next.push(command);
        command.undo();
    }

    public void redo() {
        if (next.isEmpty()) {
            System.out.println("Command is empty");
            return;
        }
        Command command = next.pop();
        prev.push(command);
        command.redo();
    }
}
