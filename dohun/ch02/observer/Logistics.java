package ch02.observer;

import ch02.Food;

public class Logistics implements Observer {
    @Override
    public void update(Food... foods) {
        for (Food food : foods) {
            System.out.println("[재입고필요] " + food.getName() + " 남은수량: " + food.getQuantity());
        }
    }
}
