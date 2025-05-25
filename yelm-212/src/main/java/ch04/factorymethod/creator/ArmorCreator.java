package ch04.factorymethod.creator;

import ch04.factorymethod.item.Item;
import ch04.factorymethod.item.Armor;

public class ArmorCreator extends ItemCreator {
    @Override
    public Item createItem(String type) {
        switch (type.toLowerCase()) {
            case "plate":
                return new Armor("강철 갑옷", 1, 15);
            case "leather":
                return new Armor("가죽 갑옷", 1, 8);
            default:
                throw new IllegalArgumentException("Unknown armor type: " + type);
        }
    }
} 