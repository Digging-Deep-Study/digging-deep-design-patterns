package me.sungbin.chapter.iterator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsArticleTest {

    @Test
    @DisplayName("유효한 정보로 뉴스 기사 생성")
    void createNewsArticle_ValidInput_Success() {
        // given
        String title = "테스트 제목";
        String content = "테스트 내용";
        String author = "테스트 기자";

        // when
        NewsArticle article = new NewsArticle(title, content, author);

        // then
        assertEquals(title, article.getTitle());
        assertEquals(content, article.getContent());
        assertEquals(author, article.getAuthor());
        assertTrue(article.getPublishedAt() > 0);
    }

    @Test
    @DisplayName("null 제목으로 기사 생성시 예외 발생")
    void createNewsArticle_NullTitle_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                new NewsArticle(null, "내용", "기자"));
    }

    @Test
    @DisplayName("빈 문자열 제목으로 기사 생성시 예외 발생")
    void createNewsArticle_EmptyTitle_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                new NewsArticle("", "내용", "기자"));
    }

    @Test
    @DisplayName("공백만 있는 제목으로 기사 생성시 예외 발생")
    void createNewsArticle_BlankTitle_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                new NewsArticle("   ", "내용", "기자"));
    }
}