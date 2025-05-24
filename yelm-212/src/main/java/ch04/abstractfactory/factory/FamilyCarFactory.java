package ch04.abstractfactory.factory;

import ch04.abstractfactory.part.Engine;
import ch04.abstractfactory.part.Wheel;
import ch04.abstractfactory.part.Body;
import ch04.abstractfactory.part.family.FamilyEngine;
import ch04.abstractfactory.part.family.FamilyWheel;
import ch04.abstractfactory.part.family.FamilyBody;

public class FamilyCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new FamilyEngine();
    }

    @Override
    public Wheel createWheel() {
        return new FamilyWheel();
    }

    @Override
    public Body createBody() {
        return new FamilyBody();
    }
} 