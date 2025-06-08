package ch06;

import ch06.command.Command;
import ch06.command.NoCommand;

import java.util.HashMap;

public class RemoteControl {

    private HashMap<String, Command> commands = new HashMap<>();

    public void setCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public void pushButton(String commandName) {
        Command command = commands.getOrDefault(commandName, new NoCommand());
        command.execute();
    }

}
