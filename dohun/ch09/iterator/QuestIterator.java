package ch09.iterator;

import java.util.Iterator;
import java.util.List;

public class QuestIterator implements Iterator<String> {
    int position = 0;
    List<String> questItems;

    public QuestIterator(List<String> questItems) {
        this.questItems = questItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= questItems.size() || questItems.get(position) == null) {
            return false;
        }

        return true;
    }

    @Override
    public String next() {
        String equipmentItem = questItems.get(position);
        position++;
        return equipmentItem;
    }
}
