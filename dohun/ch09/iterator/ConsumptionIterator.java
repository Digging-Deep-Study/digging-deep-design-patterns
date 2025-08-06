package ch09.iterator;

import java.util.Iterator;
import java.util.List;

public class ConsumptionIterator implements Iterator<String> {
    int position = 0;
    List<String> consumptionItems;

    public ConsumptionIterator(List<String> consumptionItems) {
        this.consumptionItems = consumptionItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= consumptionItems.size() || consumptionItems.get(position) == null) {
            return false;
        }

        return true;
    }

    @Override
    public String next() {
        String equipmentItem = consumptionItems.get(position);
        position++;
        return equipmentItem;
    }
}
