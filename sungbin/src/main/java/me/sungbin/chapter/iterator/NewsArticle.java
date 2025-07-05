package me.sungbin.chapter.iterator;

import java.util.Date;
import java.util.Objects;

public class NewsArticle {

    private final String title;
    private final String content;
    private final String author;
    private final long publishedAt;

    public NewsArticle(String title, String content, String author) {
        this.title = validateAndGet(title, "Title");
        this.content = validateAndGet(content, "Content");
        this.author = validateAndGet(author, "Author");
        this.publishedAt = System.currentTimeMillis();
    }

    private String validateAndGet(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
        return value.trim();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public long getPublishedAt() {
        return publishedAt;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        NewsArticle that = (NewsArticle) object;
        return getPublishedAt() == that.getPublishedAt() && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getAuthor(), that.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor(), getPublishedAt());
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - by %s", new Date(publishedAt), title, author);
    }
}
