package ch06.command;

import ch06.AirConditioner;

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
