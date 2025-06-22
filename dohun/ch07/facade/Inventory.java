package ch07.facade;

public class Inventory {
    private final int stock = 3;

    boolean isOnStock(int quantity) {
        return stock - quantity >= 0;
    }


}
