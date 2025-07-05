package ch09.composite;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SystemComponentTest {
    
    private File testFile;
    private Folder testFolder;
    
    @BeforeEach
    void setUp() {
        testFile = new File("test.txt", "Hello World");
        testFolder = new Folder("testFolder");
    }
    
    @Test
    @DisplayName("파일 이름 테스트")
    void testFileGetName() {
        assertEquals("test.txt", testFile.getName());
    }
    
    @Test
    @DisplayName("폴더 이름 테스트")
    void testFolderGetName() {
        assertEquals("testFolder", testFolder.getName());
    }
    
    @Test
    @DisplayName("파일 크기 테스트")
    void testFileGetSize() {
        assertEquals(11, testFile.getSize()); 
    }
    
    @Test
    @DisplayName("빈 폴더 크기 테스트")
    void testEmptyFolderGetSize() {
        assertEquals(0, testFolder.getSize());
    }
    
    @Test
    @DisplayName("파일에 컴포넌트 추가 시 예외 발생 테스트")
    void testFileAddThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            testFile.add(new File("another.txt", "content"));
        });
    }
    
    @Test
    @DisplayName("파일에서 컴포넌트 제거 시 예외 발생 테스트")
    void testFileRemoveThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            testFile.remove(new File("another.txt", "content"));
        });
    }
} 