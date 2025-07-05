package ch09.iterator;

import ch09.iterator.itnews.ITNewsIterator;
import ch09.iterator.itnews.ITNewsSection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ITNewsSectionTest {

    private ITNewsSection itNewsSection;

    @BeforeEach
    void setUp() {
        itNewsSection = new ITNewsSection();
    }

    @Test
    void testIteratorImplementation() {
        // Iterable 인터페이스 구현 확인
        assertTrue(itNewsSection instanceof Iterable);
        
        // iterator() 메서드가 null이 아닌 Iterator를 반환하는지 확인
        Iterator<News> iterator = itNewsSection.iterator();
        assertNotNull(iterator);
        assertTrue(iterator instanceof ITNewsIterator);
    }

    @Test
    void testForEachLoop() {
        // for-each 루프가 정상 작동하는지 확인
        int count = 0;
        for (News news : itNewsSection) {
            assertNotNull(news);
            count++;
        }
        
        // 기본적으로 2개의 뉴스가 추가되어 있음
        assertEquals(2, count);
    }

    @Test
    void testIteratorHasNext() {
        Iterator<News> iterator = itNewsSection.iterator();
        
        // 첫 번째 요소가 있는지 확인
        assertTrue(iterator.hasNext());
        
        // 첫 번째 요소를 가져옴
        News firstNews = iterator.next();
        assertNotNull(firstNews);
        
        // 두 번째 요소가 있는지 확인
        assertTrue(iterator.hasNext());
        
        // 두 번째 요소를 가져옴
        News secondNews = iterator.next();
        assertNotNull(secondNews);
        
        // 더 이상 요소가 없는지 확인
        assertFalse(iterator.hasNext());
    }

    @Test
    void testPrintAllNews() {
        String result = itNewsSection.printAllNews();
        
        // 결과가 null이 아니고 비어있지 않은지 확인
        assertNotNull(result);
        assertFalse(result.isEmpty());
        
        // 첫 번째 뉴스의 제목이 포함되어 있는지 확인
        assertTrue(result.contains("First News"));
        
        // 두 번째 뉴스의 제목이 포함되어 있는지 확인
        assertTrue(result.contains("Second"));
    }

    @Test
    void testGetFormattedNews() {
        String result = itNewsSection.getFormattedNews();
        
        // 결과가 null이 아니고 비어있지 않은지 확인
        assertNotNull(result);
        assertFalse(result.isEmpty());
        
        // 섹션 헤더가 포함되어 있는지 확인
        assertTrue(result.contains("=== IT news Section ==="));
        
        // 뉴스 내용이 포함되어 있는지 확인
        assertTrue(result.contains("First News"));
        assertTrue(result.contains("Second"));
    }

    @Test
    void testToString() {
        String result = itNewsSection.toString();
        
        // toString 결과가 예상 형식인지 확인
        assertTrue(result.contains("ITNewsSection"));
        assertTrue(result.contains("newsCount=2"));
    }

    @Test
    void testIteratorIndependence() {
        // 두 개의 Iterator가 독립적으로 작동하는지 확인
        Iterator<News> iterator1 = itNewsSection.iterator();
        Iterator<News> iterator2 = itNewsSection.iterator();
        
        // 두 Iterator 모두 첫 번째 요소가 있는지 확인
        assertTrue(iterator1.hasNext());
        assertTrue(iterator2.hasNext());
        
        // 각각 다른 요소를 가져올 수 있는지 확인
        News news1 = iterator1.next();
        News news2 = iterator2.next();
        
        assertNotNull(news1);
        assertNotNull(news2);
        assertEquals(news1.getTitle(), news2.getTitle());
    }
} 