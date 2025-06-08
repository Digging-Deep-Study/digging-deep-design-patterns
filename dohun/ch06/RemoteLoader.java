package ch06;

import ch06.command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoteLoader {
    enum Button {
        POWER, TEMPUP, TEMPDOWN, WINDUP, WINDDOWN
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 리모콘
        RemoteControl remoteControl = new RemoteControl();

        // 에어컨
        AirConditioner airConditioner = new AirConditioner();

        // 명령어 세팅
        PowerCommand powerCommand = new PowerCommand(airConditioner);
        remoteControl.setCommand(Button.POWER.name(), powerCommand);

        TurnUpTemp turnUpTemp = new TurnUpTemp(airConditioner);
        remoteControl.setCommand(Button.TEMPUP.name(), turnUpTemp);

        TurnDownTemp turnDownTemp = new TurnDownTemp(airConditioner);
        remoteControl.setCommand(Button.TEMPDOWN.name(), turnDownTemp);

        TurnUpWind turnUpWind = new TurnUpWind(airConditioner);
        remoteControl.setCommand(Button.WINDUP.name(), turnUpWind);

        TurnDownWind turnDownWind = new TurnDownWind(airConditioner);
        remoteControl.setCommand(Button.WINDDOWN.name(), turnDownWind);

        // 에어컨 작동
        airConditioner.power();

        while (airConditioner.isOn()) {
            String command = br.readLine();
            remoteControl.pushButton(command);
        }
    }
}
