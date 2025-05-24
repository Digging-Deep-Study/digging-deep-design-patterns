package ch04.abstractfactory.part.family;

import ch04.abstractfactory.part.Engine;

public class FamilyEngine implements Engine {
    @Override
    public String getType() {
        return "Family Car Engine";
    }

    @Override
    public void start() {
        System.out.println("가족용 차량 엔진 시동");
    }
} 