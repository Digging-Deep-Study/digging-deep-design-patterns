package ch12.command.command;

import ch12.command.AirConditioner;

public class TurnUpTemp implements Command {
    private AirConditioner airConditioner;

    public TurnUpTemp(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnUpTemperature();
    }
}
