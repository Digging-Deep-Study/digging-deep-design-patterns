package me.sungbin.chapter.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NewsFeedTest {

    private NewsFeed newsFeed;
    private NewsArticle article;

    @BeforeEach
    void setUp() {
        newsFeed = new NewsFeed();
        article = new NewsArticle("테스트 제목", "테스트 내용", "테스트 기자");
    }

    @Test
    @DisplayName("카테고리 추가 성공")
    void addCategory_ValidName_Success() {
        // given & when
        newsFeed.addCategory("IT");

        // then
        assertTrue(newsFeed.hasCategory("IT"));
        assertEquals(1, newsFeed.getTotalCategoriesCount());
    }

    @Test
    @DisplayName("중복 카테고리 추가시 무시됨")
    void addCategory_DuplicateName_Ignored() {
        // given
        newsFeed.addCategory("IT");

        // when
        newsFeed.addCategory("IT");

        // then
        assertEquals(1, newsFeed.getTotalCategoriesCount());
    }

    @Test
    @DisplayName("존재하는 카테고리에 기사 추가 성공")
    void addArticleToCategory_ExistingCategory_Success() {
        // given
        newsFeed.addCategory("IT");

        // when & then
        assertDoesNotThrow(() ->
                newsFeed.addArticleToCategory("IT", article));
    }

    @Test
    @DisplayName("존재하지 않는 카테고리에 기사 추가시 예외 발생")
    void addArticleToCategory_NonExistingCategory_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                newsFeed.addArticleToCategory("NonExisting", article));
    }

    @Test
    @DisplayName("빈 뉴스피드 출력")
    void displayAllArticles_EmptyFeed_PrintsNoCategories() {
        // given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // when
        newsFeed.displayAllArticles();

        // then
        assertTrue(outContent.toString().contains("사용 가능한 뉴스 카테고리가 없습니다."));
    }

    @Test
    @DisplayName("존재하지 않는 카테고리 출력시 메시지 출력")
    void displayCategoryArticles_NonExistingCategory_PrintsNotFound() {
        // given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // when
        newsFeed.displayCategoryArticles("NonExisting");

        // then
        assertTrue(outContent.toString().contains(" 카테고리를 찾을 수 없습니다."));
    }
}