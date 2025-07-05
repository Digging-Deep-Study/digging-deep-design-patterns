package ch09.iterator.sports;

import ch09.iterator.News;

import java.util.Iterator;

public class SportsNewsIterator implements Iterator<News> {
    private News[] news;
    private int currentIndex;
    private int size;

    public SportsNewsIterator(News[] news, int size) {
        this.news = news;
        this.size = size;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    @Override
    public News next() {
        if (hasNext()) {
            return news[currentIndex++];
        }
        throw new java.util.NoSuchElementException();
    }
} 