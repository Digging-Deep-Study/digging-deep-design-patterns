package ch04.abstractfactory.part.family;

import ch04.abstractfactory.part.Wheel;

public class FamilyWheel implements Wheel {
    @Override
    public String getType() {
        return "Family Car Wheel";
    }

    @Override
    public int getSize() {
        return 16;
    }

    @Override
    public void rotate() {
        System.out.println("가족용 차량 바퀴 회전");
    }
} 