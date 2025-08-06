package ch12;

import ch12.observer.Observer;
import ch12.command.AirConditioner;
import ch12.command.Button;
import ch12.command.RemoteControl;
import ch12.command.command.*;
import ch12.observer.Subject;
import ch12.state.*;

import java.util.ArrayList;
import java.util.List;

public class IoTApp implements Subject {
    RemoteControl remoteControl;
    AirConditioner airConditioner;

    private final State soCool;
    private final State cool;
    private final State soHot;
    private final State hot;

    private State state;

    List<Observer> observers = new ArrayList<>();

    public IoTApp() {
        // 리모콘
        remoteControl = new RemoteControl();

        // 에어컨
        airConditioner = new AirConditioner();

        // 명령어 세팅
        PowerCommand powerCommand = new PowerCommand(airConditioner);
        remoteControl.setCommand(Button.POWER, powerCommand);

        TurnUpTemp turnUpTemp = new TurnUpTemp(airConditioner);
        remoteControl.setCommand(Button.TEMPUP, turnUpTemp);

        TurnDownTemp turnDownTemp = new TurnDownTemp(airConditioner);
        remoteControl.setCommand(Button.TEMPDOWN, turnDownTemp);

        TurnUpWind turnUpWind = new TurnUpWind(airConditioner);
        remoteControl.setCommand(Button.WINDUP, turnUpWind);

        TurnDownWind turnDownWind = new TurnDownWind(airConditioner);
        remoteControl.setCommand(Button.WINDDOWN, turnDownWind);

        soCool = new SoCool(this, "SO COOL");
        cool = new Cool(this, "COOL");
        soHot = new SoHot(this, "SO HOT");
        hot = new Hot(this, "HOT");
        state = hot;
    }

    public void power() {
        // 에어컨 작동
        airConditioner.power();
    }

    public boolean isOn() {
        return airConditioner.isOn();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void push(Button button) {
        remoteControl.pushButton(button);
        state.update(airConditioner.getTemp());
        notifyObservers(state);
        System.out.println("IoT Device Temp: " + airConditioner.getTemp() + "도");
        System.out.println("Iot Device State: " + state.getName());
    }

    public State getSoCool() {
        return soCool;
    }

    public State getCool() {
        return cool;
    }

    public State getSoHot() {
        return soHot;
    }

    public State getHot() {
        return hot;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(State state) {
        for (Observer o : observers) {
            o.update(state);
        }
    }
}
