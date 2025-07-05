package me.sungbin.chapter.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class NewsCategory {

    private final String categoryName;
    private final List<NewsArticle> articles;

    public NewsCategory(String categoryName) {
        this.categoryName = validateCategoryName(categoryName);
        this.articles = new ArrayList<>();
    }

    private String validateCategoryName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("잘못된 카테고리 이름입니다.");
        }
        return name.trim();
    }

    public void addArticle(NewsArticle article) {
        if (article == null) {
            throw new IllegalArgumentException("잘못된 기사입니다.");
        }
        articles.add(article);
    }

    public ArticleIterator createIterator() {
        return new NewsCategoryIterator(this.articles);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getArticleCount() {
        return articles.size();
    }

    public boolean isEmpty() {
        return articles.isEmpty();
    }

    private static class NewsCategoryIterator implements ArticleIterator {
        private final List<NewsArticle> articles;
        private int currentIndex;

        public NewsCategoryIterator(List<NewsArticle> articles) {
            this.articles = new ArrayList<>(articles);
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < articles.size();
        }

        @Override
        public NewsArticle next() {
            if (hasNext()) {
                return articles.get(currentIndex++);
            }

            throw new NoSuchElementException("해당 카테고리에 더 이상 기사가 존재하지 않습니다.");
        }
    }
}
