package ch12.command.command;

import ch12.command.AirConditioner;

public class PowerCommand implements Command {
    private AirConditioner airConditioner;

    public PowerCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.power();
    }
}
