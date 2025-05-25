package ch04.abstractfactory.factory;

import ch04.abstractfactory.part.Engine;
import ch04.abstractfactory.part.Wheel;
import ch04.abstractfactory.part.Body;
import ch04.abstractfactory.part.truck.TruckEngine;
import ch04.abstractfactory.part.truck.TruckWheel;
import ch04.abstractfactory.part.truck.TruckBody;

public class TruckFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new TruckEngine();
    }

    @Override
    public Wheel createWheel() {
        return new TruckWheel();
    }

    @Override
    public Body createBody() {
        return new TruckBody();
    }
} 