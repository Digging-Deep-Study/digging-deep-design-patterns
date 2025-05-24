package ch04.abstractfactory;

import ch04.abstractfactory.factory.CarFactory;
import ch04.abstractfactory.factory.FamilyCarFactory;
import ch04.abstractfactory.factory.TruckFactory;
import ch04.abstractfactory.part.Engine;
import ch04.abstractfactory.part.Wheel;
import ch04.abstractfactory.part.Body;

public class Main {
    public static void main(String[] args) {
        // 가족용 차량 부품 생성
        CarFactory familyFactory = new FamilyCarFactory();
        Engine familyEngine = familyFactory.createEngine();
        Wheel familyWheel = familyFactory.createWheel();
        Body familyBody = familyFactory.createBody();

        // 트럭 부품 생성
        CarFactory truckFactory = new TruckFactory();
        Engine truckEngine = truckFactory.createEngine();
        Wheel truckWheel = truckFactory.createWheel();
        Body truckBody = truckFactory.createBody();

        // 가족용 차량 부품 동작
        System.out.println("=== 가족용 차량 ===");
        familyEngine.start();
        familyWheel.rotate();
        familyBody.protect();

        // 트럭 부품 동작
        System.out.println("\n=== 트럭 ===");
        truckEngine.start();
        truckWheel.rotate();
        truckBody.protect();
    }
}
