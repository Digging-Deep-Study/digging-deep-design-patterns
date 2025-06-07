package ch06.command;

import ch06.AirConditioner;

public class TurnUpWind implements Command {
    private AirConditioner airConditioner;

    public TurnUpWind(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnUpWindStrenth();
    }
}
