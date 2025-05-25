package ch04.abstractfactory.part.truck;

import ch04.abstractfactory.part.Body;

public class TruckBody implements Body {
    @Override
    public String getType() {
        return "Truck Body";
    }

    @Override
    public String getMaterial() {
        return "Heavy Steel";
    }

    @Override
    public void protect() {
        System.out.println("트럭 차체 보호");
    }
} 