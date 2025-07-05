package ch09.composite;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class FileTest {
    
    private File emptyFile;
    private File contentFile;
    private File nullContentFile;
    
    @BeforeEach
    void setUp() {
        emptyFile = new File("empty.txt", "");
        contentFile = new File("content.txt", "This is a test content");
        nullContentFile = new File("null.txt", null);
    }
    
    @Test
    @DisplayName("파일 생성자 테스트")
    void testFileConstructor() {
        assertEquals("content.txt", contentFile.getName());
        assertEquals("This is a test content", contentFile.getContent());
    }
    
    @Test
    @DisplayName("빈 파일 크기 테스트")
    void testEmptyFileSize() {
        assertEquals(0, emptyFile.getSize());
    }
    
    @Test
    @DisplayName("내용이 있는 파일 크기 테스트")
    void testContentFileSize() {
        assertEquals(22, contentFile.getSize()); 
    }
    
    @Test
    @DisplayName("null 내용 파일 크기 테스트")
    void testNullContentFileSize() {
        assertEquals(0, nullContentFile.getSize());
    }
    
    @Test
    @DisplayName("파일 내용 테스트")
    void testFileGetContent() {
        assertEquals("This is a test content", contentFile.getContent());
    }
    
    @Test
    @DisplayName("파일에 컴포넌트 추가 시 예외 발생 테스트")
    void testFileAddOperation() {
        assertThrows(UnsupportedOperationException.class, () -> {
            contentFile.add(new File("another.txt", "content"));
        });
    }
    
    @Test
    @DisplayName("파일에서 컴포넌트 제거 시 예외 발생 테스트")
    void testFileRemoveOperation() {
        assertThrows(UnsupportedOperationException.class, () -> {
            contentFile.remove(new File("another.txt", "content"));
        });
    }
} 