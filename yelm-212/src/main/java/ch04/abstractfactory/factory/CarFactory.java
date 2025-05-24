package ch04.abstractfactory.factory;

import ch04.abstractfactory.part.Engine;
import ch04.abstractfactory.part.Wheel;
import ch04.abstractfactory.part.Body;

public interface CarFactory {
    Engine createEngine();
    Wheel createWheel();
    Body createBody();
} 