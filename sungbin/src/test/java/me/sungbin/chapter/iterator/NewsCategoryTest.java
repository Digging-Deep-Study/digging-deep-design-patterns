package me.sungbin.chapter.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class NewsCategoryTest {

    private NewsCategory category;

    private NewsArticle article1;

    private NewsArticle article2;

    @BeforeEach
    void setUp() {
        category = new NewsCategory("테스트 카테고리");
        article1 = new NewsArticle("제목1", "내용1", "기자1");
        article2 = new NewsArticle("제목2", "내용2", "기자2");
    }

    @Test
    @DisplayName("카테고리 생성 성공")
    void createCategory_ValidName_Success() {
        // given & when
        NewsCategory newCategory = new NewsCategory("IT");

        // then
        assertEquals("IT", newCategory.getCategoryName());
        assertTrue(newCategory.isEmpty());
        assertEquals(0, newCategory.getArticleCount());
    }

    @Test
    @DisplayName("null 카테고리명으로 생성시 예외 발생")
    void createCategory_NullName_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                new NewsCategory(null));
    }

    @Test
    @DisplayName("기사 추가 성공")
    void addArticle_ValidArticle_Success() {
        // given & when
        category.addArticle(article1);

        // then
        assertEquals(1, category.getArticleCount());
        assertFalse(category.isEmpty());
    }

    @Test
    @DisplayName("null 기사 추가시 예외 발생")
    void addArticle_NullArticle_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                category.addArticle(null));
    }

    @Test
    @DisplayName("Iterator를 통한 기사 순회")
    void iterator_MultipleArticles_IteratesInOrder() {
        // given
        category.addArticle(article1);
        category.addArticle(article2);

        // when
        ArticleIterator iterator = category.createIterator();

        // then
        assertTrue(iterator.hasNext());
        assertEquals(article1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(article2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("빈 카테고리에서 Iterator 사용")
    void iterator_EmptyCategory_HasNextReturnsFalse() {
        // given & when
        ArticleIterator iterator = category.createIterator();

        // then
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Iterator에서 더 이상 요소가 없을 때 next() 호출시 예외 발생")
    void iterator_NoMoreElements_ThrowsException() {
        // given
        ArticleIterator iterator = category.createIterator();

        // when & then
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}