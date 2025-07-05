package ch09.iterator.itnews;

import ch09.iterator.News;

import java.util.Iterator;
import java.util.List;

public class ITNewsIterator implements Iterator<News> {
    private List<News> itNews;
    private int index;

    public ITNewsIterator(List<News> itNews) {
        this.itNews = itNews;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < itNews.size();
    }

    @Override
    public News next() {
        return itNews.get(index++);
    }

}
