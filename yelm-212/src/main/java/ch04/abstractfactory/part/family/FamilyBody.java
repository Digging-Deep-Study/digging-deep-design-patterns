package ch04.abstractfactory.part.family;

import ch04.abstractfactory.part.Body;

public class FamilyBody implements Body {
    @Override
    public String getType() {
        return "Family Car Body";
    }

    @Override
    public String getMaterial() {
        return "Steel";
    }

    @Override
    public void protect() {
        System.out.println("가족용 차량 차체 보호");
    }
} 