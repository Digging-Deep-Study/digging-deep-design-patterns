package ch02;

import ch02.observer.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderSystem implements Subject {
    List<Observer> observers = new ArrayList<>();

    private Inventory inventory = new Inventory();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Food food) {
        for (Observer o : observers) {
            o.update(food);
        }
    }

    public void createOrder(String name, int orderCount) {
        if (!inventory.isOnStock(name, orderCount)) {
            System.out.println("주문할 재고가 부족합니다.");
        }

        Food orderFood = inventory.find(name);
        orderFood.decreaseQuantity(orderCount);

        notifyObservers(orderFood);
    }

    static class Inventory {
        private HashMap<String, Food> inventory = new HashMap<>();

        public Inventory() {
            Food pork = new Pork("돼지고기", 5);
            Food beef = new Beef("소고기", 10);
            Food egg = new Egg("달걀", 30);

            inventory.put(pork.getName(), pork);
            inventory.put(beef.getName(), beef);
            inventory.put(egg.getName(), egg);
        }

        public boolean isOnStock(String name, int orderCount) {
            return inventory.get(name).getQuantity() >= orderCount;
        }

        public Food find(String name) {
            return inventory.get(name);
        }
    }
}
