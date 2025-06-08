package ch06.command;

import ch06.AirConditioner;

public class TurnDownTemp implements Command {
    private AirConditioner airConditioner;

    public TurnDownTemp(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnDownTemperature();
    }
}
