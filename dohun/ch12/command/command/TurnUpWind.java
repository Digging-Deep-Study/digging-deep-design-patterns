package ch12.command.command;

import ch12.command.AirConditioner;

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
