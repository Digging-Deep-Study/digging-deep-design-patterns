package ch09.iterator.item;

import ch09.iterator.QuestIterator;

import java.util.Iterator;
import java.util.List;

public class QuestItem implements Item {
    List<String> quests;

    public QuestItem(String... quests) {
        this.quests = List.of(quests);
    }

    @Override
    public Iterator<String> createIterator() {
        return new QuestIterator(quests);
    }
}
