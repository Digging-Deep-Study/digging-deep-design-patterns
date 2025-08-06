package ch09.iterator.item;

import ch09.iterator.ConsumptionIterator;

import java.util.Iterator;
import java.util.List;

public class ConsumptionItem implements Item {
    List<String> consumptions;

    public ConsumptionItem(String... consumptions) {
        this.consumptions = List.of(consumptions);
    }

    @Override
    public Iterator<String> createIterator() {
        return new ConsumptionIterator(consumptions);
    }
}
