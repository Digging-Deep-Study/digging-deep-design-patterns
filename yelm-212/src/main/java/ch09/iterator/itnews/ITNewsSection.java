package ch09.iterator.itnews;

import ch09.iterator.News;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ITNewsSection implements Iterable<News> {
    private List<News> news;

    public ITNewsSection() {
        news = new ArrayList<>();

        addNews(new News("First News", "This is first news"));
        addNews(new News("Second", "second content"));
    }

    private void addNews(News news) {
        this.news.add(news);
    }

    @Override
    public String toString(){
        return "ITNewsSection{newsCount=" + news.size() + "}";
    }

    public String getFormattedNews() {
        return "=== IT news Section ===\n" + printAllNews();
    }

    public String printAllNews() {
        StringBuilder sb = new StringBuilder();
        Iterator<News> iterator = iterator();
        while (iterator.hasNext()) {
            News news = iterator.next();
            sb.append(news);
        }

        return sb.toString();
    }

    @Override
    public Iterator<News> iterator() {
        return new ITNewsIterator(this.news);
    }
}
