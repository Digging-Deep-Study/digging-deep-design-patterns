package ch09.composite;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }
}

class ITNewsIterator implements Iterator<ITNewsSection> {
    private List<News> itNews;

    public ITNewsIterator(List<News> itNews) {
        this.itNews = itNews;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public ITNewsSection next() {
        return null;
    }
}

@Builder
class News {
    private String title;
    private String content;

    @Override
    public String toString() {
        return "News [title=" + title + "\ncontent=" + content + "]";
    }
}

class ITNewsSection {
    private List<News> news;

    public ITNewsSection() {
        news = new ArrayList<>();

        addNews(News.builder().title("First News").content("This is first news").build());
        addNews(News.builder().title("Second").content("scecond content").build());
    }

    private void addNews(News news) {
        this.news.add(news);
    }

    @Override
    public String toString(){
        return "=== IT news Section ===\n" + news.toString();
    }

    public Iterator<ITNewsSection> iterator() {
        return new ITNewsIterator(this.news);
    }
}