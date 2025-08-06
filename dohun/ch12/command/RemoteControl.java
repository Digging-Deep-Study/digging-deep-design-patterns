package ch12.command;

import ch12.command.command.Command;
import ch12.command.command.NoCommand;

import java.util.HashMap;

public class RemoteControl {

    private HashMap<Button, Command> commands = new HashMap<>();

    public void setCommand(Button button, Command command) {
        commands.put(button, command);
    }

    public void pushButton(Button button) {
        Command command = commands.getOrDefault(button, new NoCommand());
        command.execute();
    }

}
