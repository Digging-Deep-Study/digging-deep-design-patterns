package ch04.abstractfactory.part.truck;

import ch04.abstractfactory.part.Wheel;

public class TruckWheel implements Wheel {
    @Override
    public String getType() {
        return "Truck Wheel";
    }

    @Override
    public int getSize() {
        return 22;
    }

    @Override
    public void rotate() {
        System.out.println("트럭 바퀴 회전");
    }
} 