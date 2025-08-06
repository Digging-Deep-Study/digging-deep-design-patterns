package ch09.iterator.item;

import ch09.iterator.EquipmentIterator;

import java.util.Iterator;
import java.util.List;

public class EquipmentItem implements Item {
    List<String> equipments;

    public EquipmentItem(String... equipments) {
        this.equipments = List.of(equipments);
    }

    @Override
    public Iterator<String> createIterator() {
        return new EquipmentIterator(equipments);
    }
}
