package ch12.command.command;

import ch12.command.AirConditioner;

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
