package ch09.iterator;

import java.util.Iterator;
import java.util.List;

public class EquipmentIterator implements Iterator<String> {
    int position = 0;
    List<String> equipmentItems;

    public EquipmentIterator(List<String> equipmentItems) {
        this.equipmentItems = equipmentItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= equipmentItems.size() || equipmentItems.get(position) == null) {
            return false;
        }

        return true;
    }

    @Override
    public String next() {
        String equipmentItem = equipmentItems.get(position);
        position++;
        return equipmentItem;
    }
}
