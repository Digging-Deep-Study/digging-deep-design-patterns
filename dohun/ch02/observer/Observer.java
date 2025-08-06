package ch02.observer;

import ch02.Food;

public interface Observer {
    void update(Food... foods);
}
