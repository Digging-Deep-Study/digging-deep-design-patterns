package ch06;

public class AirConditioner {

    private boolean isOn;
    private int temp = 24;
    private int wind = 3;

    public void power() {
        isOn = !isOn;

        if (isOn) System.out.println("에어컨이 켜졌습니다.");
        else System.out.println("에어컨이 꺼졌습니다.");
    }

    public void turnUpTemperature() {
        if (temp < 30) temp++;

        System.out.println("현재 에어컨 온도는 " + temp + "도 입니다.");
    }

    public void turnDownTemperature() {
        if (temp > 18) temp--;

        System.out.println("현재 에어컨 온도는 " + temp + "도 입니다.");
    }

    public void turnUpWindStrenth() {
        if (wind < 5) wind++;

        System.out.println("현재 에어컨 바람 세기는 " + wind + "단계 입니다.");
    }

    public void turnDownWindStrenth() {
        if (wind > 1) wind--;

        System.out.println("현재 에어컨 바람 세기는 " + wind + "단계 입니다.");
    }

    public boolean isOn() {
        return isOn;
    }

}
