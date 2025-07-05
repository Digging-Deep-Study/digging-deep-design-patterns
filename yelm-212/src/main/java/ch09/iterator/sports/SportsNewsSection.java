package ch09.iterator.sports;

import ch09.iterator.News;

import java.util.Iterator;

public class SportsNewsSection implements Iterable<News> {
    private News[] news;
    private int currentSize;
    private static final int MAX_SIZE = 10;

    public SportsNewsSection() {
        this.news = new News[MAX_SIZE];
        this.currentSize = 0;

        addNews(new News("Soccer Match", "Soccer news"));
        addNews(new News("Basketball", "Basketball news"));
        addNews(new News("Tennis", "Tennis news"));
    }

    public void addNews(News news) {
        if (currentSize < MAX_SIZE) {
            this.news[currentSize++] = news;
        } else {
            System.out.println("Warning: Maximum news limit reached (10)");
        }
    }

    @Override
    public String toString() {
        return "SportsNewsSection{newsCount=" + currentSize + ", maxSize=" + MAX_SIZE + "}";
    }

    public String getFormattedNews() {
        return "=== Sports News Section ===\n" + printAllNews();
    }

    public String printAllNews() {
        StringBuilder sb = new StringBuilder();
        for (News news : this) {
            sb.append(news);
        }
        return sb.toString();
    }

    @Override
    public Iterator<News> iterator() {
        return new SportsNewsIterator(this.news, this.currentSize);
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public boolean isFull() {
        return currentSize >= MAX_SIZE;
    }
} 