package ch12;

import ch12.command.Button;
import ch12.observer.IoTAppUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        IoTApp app = new IoTApp();
        app.registerObserver(new IoTAppUI());
        app.power();

        while (app.isOn()) {
            String command = br.readLine();

            try {
                Button button = Button.valueOf(command);
                app.push(button);
            } catch (Exception e) {
                System.out.println("잘못된 명령어입니다.");
            }
        }

    }
}
