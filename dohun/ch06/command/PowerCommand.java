package ch06.command;

import ch06.AirConditioner;

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
