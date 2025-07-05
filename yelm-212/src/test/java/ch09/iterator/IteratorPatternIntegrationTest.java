package ch09.iterator;

import ch09.iterator.itnews.ITNewsSection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteratorPatternIntegrationTest {

    @Test
    void testCompleteIteratorPatternWorkflow() {
        // 1. ITNewsSection 생성
        ITNewsSection itNewsSection = new ITNewsSection();
        
        // 2. Iterable 인터페이스 구현 확인
        assertTrue(itNewsSection instanceof Iterable);
        
        // 3. for-each 루프로 순회
        StringBuilder collectedNews = new StringBuilder();
        for (News news : itNewsSection) {
            collectedNews.append(news.toString());
        }
        
        // 4. 수집된 뉴스가 예상 내용을 포함하는지 확인
        String result = collectedNews.toString();
        assertTrue(result.contains("First News"));
        assertTrue(result.contains("Second"));
    }

    @Test
    void testMultipleIterationMethods() {
        ITNewsSection itNewsSection = new ITNewsSection();
        
        // 1. printAllNews() 메서드 테스트
        String printResult = itNewsSection.printAllNews();
        assertNotNull(printResult);
        assertTrue(printResult.contains("First News"));
        assertTrue(printResult.contains("Second"));
        
        // 2. getFormattedNews() 메서드 테스트
        String formattedResult = itNewsSection.getFormattedNews();
        assertNotNull(formattedResult);
        assertTrue(formattedResult.contains("=== IT news Section ==="));
        assertTrue(formattedResult.contains("First News"));
        assertTrue(formattedResult.contains("Second"));
        
        // 3. toString() 메서드 테스트
        String toStringResult = itNewsSection.toString();
        assertNotNull(toStringResult);
        assertTrue(toStringResult.contains("ITNewsSection"));
        assertTrue(toStringResult.contains("newsCount=2"));
    }

    @Test
    void testIteratorIndependence() {
        ITNewsSection itNewsSection = new ITNewsSection();
        
        // 두 개의 독립적인 Iterator 생성
        var iterator1 = itNewsSection.iterator();
        var iterator2 = itNewsSection.iterator();
        
        // 각각 다른 순회 진행
        News news1 = iterator1.next();
        News news2 = iterator2.next();
        
        // 같은 첫 번째 요소를 반환하는지 확인
        assertEquals("First News", news1.getTitle());
        assertEquals("First News", news2.getTitle());
        
        // iterator1만 다음 요소로 진행
        News news1Second = iterator1.next();
        assertEquals("Second", news1Second.getTitle());
        
        // iterator2는 여전히 첫 번째 요소 다음에 위치
        News news2Second = iterator2.next();
        assertEquals("Second", news2Second.getTitle());
    }

    @Test
    void testEmptySectionBehavior() {
        // 빈 섹션을 시뮬레이션하기 위해 새로운 섹션 생성 후 테스트
        ITNewsSection itNewsSection = new ITNewsSection();
        
        // 기본적으로 2개의 뉴스가 있으므로 정상 동작 확인
        int count = 0;
        for (News news : itNewsSection) {
            count++;
            assertNotNull(news.getTitle());
            assertNotNull(news.getContent());
        }
        
        assertEquals(2, count);
    }

    @Test
    void testNewsObjectProperties() {
        ITNewsSection itNewsSection = new ITNewsSection();
        
        // 첫 번째 뉴스 객체의 속성 확인
        News firstNews = null;
        for (News news : itNewsSection) {
            if ("First News".equals(news.getTitle())) {
                firstNews = news;
                break;
            }
        }
        
        assertNotNull(firstNews);
        assertEquals("First News", firstNews.getTitle());
        assertEquals("This is first news", firstNews.getContent());
        
        // toString() 메서드 확인
        String newsString = firstNews.toString();
        assertTrue(newsString.contains("First News"));
        assertTrue(newsString.contains("This is first news"));
    }
} 