package ch04.factorymethod.creator;

import ch04.factorymethod.item.Item;
import ch04.factorymethod.item.Weapon;

public class WeaponCreator extends ItemCreator {
    @Override
    public Item createItem(String type) {
        switch (type.toLowerCase()) {
            case "sword":
                return new Weapon("강철 검", 1, 10);
            case "bow":
                return new Weapon("장궁", 1, 8);
            default:
                throw new IllegalArgumentException("Unknown weapon type: " + type);
        }
    }
} 