package ch09.composite;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class FolderTest {
    
    private Folder emptyFolder;
    private Folder testFolder;
    private File testFile1;
    private File testFile2;
    private Folder subFolder;
    
    @BeforeEach
    void setUp() {
        emptyFolder = new Folder("empty");
        testFolder = new Folder("test");
        testFile1 = new File("file1.txt", "content1");
        testFile2 = new File("file2.txt", "content2");
        subFolder = new Folder("subfolder");
    }
    
    @Test
    @DisplayName("빈 폴더 크기 테스트")
    void testEmptyFolderSize() {
        assertEquals(0, emptyFolder.getSize());
    }
    
    @Test
    @DisplayName("파일이 포함된 폴더 크기 테스트")
    void testFolderWithFilesSize() {
        testFolder.add(testFile1);
        testFolder.add(testFile2);
        assertEquals(16, testFolder.getSize()); // "content1" + "content2" = 8 + 8 = 16
    }
    
    @Test
    @DisplayName("중첩된 폴더 구조 크기 테스트")
    void testFolderWithNestedStructure() {
        subFolder.add(testFile1);
        testFolder.add(subFolder);
        testFolder.add(testFile2);
        assertEquals(16, testFolder.getSize()); // "content1" + "content2" = 8 + 8 = 16
    }
    
    @Test
    @DisplayName("폴더에 파일 추가 테스트")
    void testAddFile() {
        testFolder.add(testFile1);
        List<SystemComponent> children = testFolder.getChildren();
        assertEquals(1, children.size());
        assertTrue(children.contains(testFile1));
    }
    
    @Test
    @DisplayName("폴더에 하위 폴더 추가 테스트")
    void testAddFolder() {
        testFolder.add(subFolder);
        List<SystemComponent> children = testFolder.getChildren();
        assertEquals(1, children.size());
        assertTrue(children.contains(subFolder));
    }
    
    @Test
    @DisplayName("폴더에서 파일 제거 테스트")
    void testRemoveFile() {
        testFolder.add(testFile1);
        testFolder.add(testFile2);
        testFolder.remove(testFile1);
        
        List<SystemComponent> children = testFolder.getChildren();
        assertEquals(1, children.size());
        assertFalse(children.contains(testFile1));
        assertTrue(children.contains(testFile2));
    }
    
    @Test
    @DisplayName("폴더에서 하위 폴더 제거 테스트")
    void testRemoveFolder() {
        testFolder.add(subFolder);
        testFolder.add(testFile1);
        testFolder.remove(subFolder);
        
        List<SystemComponent> children = testFolder.getChildren();
        assertEquals(1, children.size());
        assertFalse(children.contains(subFolder));
        assertTrue(children.contains(testFile1));
    }
    
    @Test
    @DisplayName("getChildren() 테스트")
    void testGetChildrenReturnsCopy() {
        testFolder.add(testFile1);
        List<SystemComponent> children1 = testFolder.getChildren();
        List<SystemComponent> children2 = testFolder.getChildren();
        
        assertNotSame(children1, children2); 
        assertEquals(children1.size(), children2.size());
    }
    
    @Test
    @DisplayName("폴더 내 항목 수 테스트")
    void testFolderItemCount() {
        testFolder.add(testFile1);
        testFolder.add(testFile2);
        testFolder.add(subFolder);
        
        List<SystemComponent> children = testFolder.getChildren();
        assertEquals(3, children.size());
    }
} 