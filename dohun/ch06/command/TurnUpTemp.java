package ch06.command;

import ch06.AirConditioner;

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
