package me.sungbin.chapter.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemManagerTest {

    private FileSystemManager fileSystem;

    @BeforeEach
    void setUp() {
        fileSystem = new FileSystemManager("TestRoot");
    }

    @Test
    @DisplayName("파일 시스템 생성")
    void createFileSystem_ValidRootName_Success() {
        // given & when
        FileSystemManager fs = new FileSystemManager("MySystem");

        // then
        assertNotNull(fs.getRootFolder());
        assertEquals("MySystem", fs.getRootFolder().getName());
        assertTrue(fs.getRootFolder().isDirectory());
    }

    @Test
    @DisplayName("빈 파일 시스템 통계")
    void getStatistics_EmptyFileSystem_ReturnsZero() {
        // given & when & then
        assertEquals(0, fileSystem.getTotalSize());
        assertEquals(0, fileSystem.getTotalFileCount());
        assertEquals(1, fileSystem.getTotalFolderCount()); // root folder
    }

    @Test
    @DisplayName("파일 추가 후 통계 확인")
    void getStatistics_WithFiles_ReturnsCorrectValues() {
        // given
        Folder root = fileSystem.getRootFolder();
        File file1 = new File("test1.txt", 1024);
        File file2 = new File("test2.txt", 2048);
        Folder subfolder = new Folder("subfolder");

        root.add(file1);
        subfolder.add(file2);
        root.add(subfolder);

        // when & then
        assertEquals(3072, fileSystem.getTotalSize());
        assertEquals(2, fileSystem.getTotalFileCount());
        assertEquals(2, fileSystem.getTotalFolderCount());
    }

    @Test
    @DisplayName("검색 기능 - 존재하는 파일")
    void search_ExistingFile_ReturnsFile() {
        // given
        File file = new File("target.txt", 1024);
        fileSystem.getRootFolder().add(file);

        // when
        FileSystemComponent result = fileSystem.search("target.txt");

        // then
        assertEquals(file, result);
    }

    @Test
    @DisplayName("검색 기능 - 존재하지 않는 파일")
    void search_NonExistingFile_ReturnsNull() {
        // given & when
        FileSystemComponent result = fileSystem.search("nonexistent.txt");

        // then
        assertNull(result);
    }
}