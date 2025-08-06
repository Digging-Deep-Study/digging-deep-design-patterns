package ch12.command.command;

import ch12.command.AirConditioner;

public class TurnDownWind implements Command {
    private AirConditioner airConditioner;

    public TurnDownWind(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnDownWindStrenth();
    }
}
