package ch09.iterator;

import ch09.iterator.item.Item;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    List<Item> items;

    public Inventory(Item... items) {
        this.items = List.of(items);
    }

    public void printItems() {
        for (Item next : items) {
            printItem(next.createIterator());
        }
    }

    public void printItem(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
