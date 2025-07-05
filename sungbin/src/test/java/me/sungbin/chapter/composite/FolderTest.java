package me.sungbin.chapter.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FolderTest {

    private Folder folder;
    private File file1;
    private File file2;
    private Folder subFolder;

    @BeforeEach
    void setUp() {
        folder = new Folder("testFolder");
        file1 = new File("file1.txt", 1024);
        file2 = new File("file2.txt", 2048);
        subFolder = new Folder("subFolder");
    }

    @Test
    @DisplayName("빈 폴더 생성")
    void createFolder_Valid_Success() {
        // given & when
        Folder newFolder = new Folder("myFolder");

        // then
        assertEquals("myFolder", newFolder.getName());
        assertTrue(newFolder.isDirectory());
        assertTrue(newFolder.isEmpty());
        assertEquals(0, newFolder.getChildCount());
        assertEquals(0, newFolder.getSize());
    }

    @Test
    @DisplayName("폴더에 파일 추가")
    void add_File_Success() {
        // given & when
        folder.add(file1);

        // then
        assertEquals(1, folder.getChildCount());
        assertFalse(folder.isEmpty());
        assertEquals(file1.getSize(), folder.getSize());
        assertTrue(folder.getChildren().contains(file1));
    }

    @Test
    @DisplayName("폴더에 하위 폴더 추가")
    void add_Subfolder_Success() {
        // given
        subFolder.add(file1);

        // when
        folder.add(subFolder);

        // then
        assertEquals(1, folder.getChildCount());
        assertEquals(file1.getSize(), folder.getSize());
        assertTrue(folder.getChildren().contains(subFolder));
    }

    @Test
    @DisplayName("중복 이름의 컴포넌트 추가시 예외 발생")
    void add_DuplicateName_ThrowsException() {
        // given
        folder.add(file1);
        File duplicateFile = new File("file1.txt", 512);

        // when & then
        assertThrows(IllegalArgumentException.class, () ->
                folder.add(duplicateFile));
    }

    @Test
    @DisplayName("null 컴포넌트 추가시 예외 발생")
    void add_NullComponent_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                folder.add(null));
    }

    @Test
    @DisplayName("자기 자신을 추가시 예외 발생")
    void add_SelfReference_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                folder.add(folder));
    }

    @Test
    @DisplayName("컴포넌트 제거 성공")
    void remove_ExistingComponent_Success() {
        // given
        folder.add(file1);
        folder.add(file2);

        // when
        folder.remove(file1);

        // then
        assertEquals(1, folder.getChildCount());
        assertEquals(file2.getSize(), folder.getSize());
        assertFalse(folder.getChildren().contains(file1));
    }

    @Test
    @DisplayName("존재하지 않는 컴포넌트 제거시 예외 발생")
    void remove_NonExistingComponent_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                folder.remove(file1));
    }

    @Test
    @DisplayName("폴더 크기 계산 (하위 요소들의 합)")
    void getSize_WithMultipleComponents_ReturnsSum() {
        // given
        folder.add(file1);
        folder.add(file2);
        subFolder.add(new File("subFile.txt", 512));
        folder.add(subFolder);

        // when
        long totalSize = folder.getSize();

        // then
        assertEquals(1024 + 2048 + 512, totalSize);
    }

    @Test
    @DisplayName("이름으로 컴포넌트 검색 - 직접 자식")
    void findByName_DirectChild_ReturnsComponent() {
        // given
        folder.add(file1);

        // when
        FileSystemComponent result = folder.findByName("file1.txt");

        // then
        assertEquals(file1, result);
    }

    @Test
    @DisplayName("이름으로 컴포넌트 검색 - 하위 폴더 내부")
    void findByName_NestedChild_ReturnsComponent() {
        // given
        subFolder.add(file1);
        folder.add(subFolder);

        // when
        FileSystemComponent result = folder.findByName("file1.txt");

        // then
        assertEquals(file1, result);
    }

    @Test
    @DisplayName("모든 파일 수집")
    void getAllFiles_WithNestedStructure_ReturnsAllFiles() {
        // given
        folder.add(file1);
        subFolder.add(file2);
        folder.add(subFolder);

        // when
        List<File> allFiles = folder.getAllFiles();

        // then
        assertEquals(2, allFiles.size());
        assertTrue(allFiles.contains(file1));
        assertTrue(allFiles.contains(file2));
    }

    @Test
    @DisplayName("모든 폴더 수집")
    void getAllFolders_WithNestedStructure_ReturnsAllFolders() {
        // given
        Folder nestedFolder = new Folder("nested");
        subFolder.add(nestedFolder);
        folder.add(subFolder);

        // when
        List<Folder> allFolders = folder.getAllFolders();

        // then
        assertEquals(2, allFolders.size());
        assertTrue(allFolders.contains(subFolder));
        assertTrue(allFolders.contains(nestedFolder));
    }
}