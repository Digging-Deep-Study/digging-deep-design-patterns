package ch09.iterator.item;

import java.util.Iterator;

public interface Item {
    Iterator<String> createIterator();
}
