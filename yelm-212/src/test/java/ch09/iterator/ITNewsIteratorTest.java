package ch09.iterator;

import ch09.iterator.itnews.ITNewsIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ITNewsIteratorTest {

    private List<News> newsList;
    private ITNewsIterator iterator;

    @BeforeEach
    void setUp() {
        newsList = new ArrayList<>();
        newsList.add(new News("Test News 1", "Content 1"));
        newsList.add(new News("Test News 2", "Content 2"));
        newsList.add(new News("Test News 3", "Content 3"));
        
        iterator = new ITNewsIterator(newsList);
    }

    @Test
    void testIteratorImplementation() {
        // Iterator 인터페이스 구현 확인
        assertTrue(iterator instanceof Iterator);
    }

    @Test
    void testHasNextWithElements() {
        // 요소가 있을 때 hasNext()가 true를 반환하는지 확인
        assertTrue(iterator.hasNext());
    }

    @Test
    void testHasNextWithoutElements() {
        // 모든 요소를 소비한 후 hasNext()가 false를 반환하는지 확인
        iterator.next(); // 첫 번째 요소
        iterator.next(); // 두 번째 요소
        iterator.next(); // 세 번째 요소
        
        assertFalse(iterator.hasNext());
    }

    @Test
    void testNextIncrementsIndex() {
        // next() 호출 시 인덱스가 증가하는지 확인
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testEmptyList() {
        // 빈 리스트로 Iterator 생성
        List<News> emptyList = new ArrayList<>();
        ITNewsIterator emptyIterator = new ITNewsIterator(emptyList);
        
        // 빈 리스트에서는 hasNext()가 false를 반환
        assertFalse(emptyIterator.hasNext());
    }

    @Test
    void testIteratorWithSingleElement() {
        // 단일 요소 리스트로 테스트
        List<News> singleElementList = new ArrayList<>();
        singleElementList.add(new News("Single News", "Single Content"));
        
        ITNewsIterator singleIterator = new ITNewsIterator(singleElementList);
        
        assertTrue(singleIterator.hasNext());
        News news = singleIterator.next();
        assertEquals("Single News", news.getTitle());
        assertEquals("Single Content", news.getContent());
        assertFalse(singleIterator.hasNext());
    }

    @Test
    void testIteratorConstructor() {
        // 생성자가 올바르게 초기화하는지 확인
        List<News> testList = new ArrayList<>();
        testList.add(new News("Constructor Test", "Test Content"));
        
        ITNewsIterator testIterator = new ITNewsIterator(testList);
        
        // 초기 상태에서 hasNext()가 true를 반환
        assertTrue(testIterator.hasNext());
    }

    @Test
    void testMultipleIterationsOnSameList() {
        // 같은 리스트로 여러 Iterator 생성
        ITNewsIterator iterator1 = new ITNewsIterator(newsList);
        ITNewsIterator iterator2 = new ITNewsIterator(newsList);
        
        // 두 Iterator가 독립적으로 작동하는지 확인
        assertTrue(iterator1.hasNext());
        assertTrue(iterator2.hasNext());
        
        News news1 = iterator1.next();
        News news2 = iterator2.next();
        
        // 같은 요소를 반환하는지 확인
        assertEquals(news1.getTitle(), news2.getTitle());
        assertEquals(news1.getContent(), news2.getContent());
    }
} 