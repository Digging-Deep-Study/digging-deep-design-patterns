package ch02;

import ch02.observer.Logistics;
import ch02.observer.User;

public class Coupang {
    public static void main(String[] args) {

        OrderSystem orderSystem = new OrderSystem();
        orderSystem.registerObserver(new User());
        orderSystem.registerObserver(new Logistics());

        orderSystem.createOrder("돼지고기", 2);
        orderSystem.createOrder("소고기", 8);
        orderSystem.createOrder("달걀", 20);

    }
}
