package me.sungbin.chapter.iterator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NewsFeed {

    private final Map<String, NewsCategory> categories;

    public NewsFeed() {
        this.categories = new HashMap<>();
    }

    public void addCategory(String categoryName) {
        if (!categories.containsKey(categoryName)) {
            categories.put(categoryName, new NewsCategory(categoryName));
        }
    }

    public void addArticleToCategory(String categoryName, NewsArticle article) {
        NewsCategory category = categories.get(categoryName);
        if (category == null) {
            throw new IllegalArgumentException(categoryName + " 카테고리를 찾을 수 없습니다.");
        }
        category.addArticle(article);
    }

    public void displayAllArticles() {
        if (categories.isEmpty()) {
            System.out.println("사용 가능한 뉴스 카테고리가 없습니다.");
            return;
        }

        categories.values().forEach(this::displayCategoryArticles);
    }

    public void displayCategoryArticles(String categoryName) {
        NewsCategory category = categories.get(categoryName);
        if (category == null) {
            System.out.println(categoryName + " 카테고리를 찾을 수 없습니다.");
            return;
        }
        displayCategoryArticles(category);
    }

    private void displayCategoryArticles(NewsCategory category) {
        System.out.println("\n=== " + category.getCategoryName() + " ===");

        if (category.isEmpty()) {
            System.out.println("사용 가능한 뉴스 카테고리가 없습니다.");
            return;
        }

        ArticleIterator iterator = category.createIterator();
        int articleNumber = 1;

        while (iterator.hasNext()) {
            NewsArticle article = iterator.next();
            System.out.printf("%d. %s%n", articleNumber++, article);
        }
    }

    public Set<String> getCategoryNames() {
        return new HashSet<>(categories.keySet());
    }

    public int getTotalCategoriesCount() {
        return categories.size();
    }

    public boolean hasCategory(String categoryName) {
        return categories.containsKey(categoryName);
    }
}
