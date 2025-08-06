package ch02.observer;

import ch02.Food;

public class User implements Observer {
    @Override
    public void update(Food... foods) {
        for (Food food : foods) {
            if (food.getQuantity() > 0) System.out.println("[품절임박] " + food.getName() + " 남은수량: " + food.getQuantity());
            else System.out.println("[품절] " + food.getName());
        }
    }
}
