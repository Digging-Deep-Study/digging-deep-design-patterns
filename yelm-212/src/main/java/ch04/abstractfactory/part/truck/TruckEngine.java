package ch04.abstractfactory.part.truck;

import ch04.abstractfactory.part.Engine;

public class TruckEngine implements Engine {
    @Override
    public String getType() {
        return "Truck Engine";
    }

    @Override
    public void start() {
        System.out.println("트럭 엔진 시동");
    }
} 