package me.sungbin.chapter.composite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @Test
    @DisplayName("유효한 파일 생성")
    void createFile_ValidParameters_Success() {
        // given
        String fileName = "test.txt";
        long fileSize = 1024;

        // when
        File file = new File(fileName, fileSize);

        // then
        assertEquals(fileName, file.getName());
        assertEquals(fileSize, file.getSize());
        assertEquals("txt", file.getExtension());
        assertFalse(file.isDirectory());
        assertTrue(file.getCreatedAt() > 0);
    }

    @Test
    @DisplayName("확장자가 없는 파일 생성")
    void createFile_NoExtension_Success() {
        // given
        String fileName = "README";
        long fileSize = 512;

        // when
        File file = new File(fileName, fileSize);

        // then
        assertEquals("", file.getExtension());
    }

    @Test
    @DisplayName("null 파일명으로 생성시 예외 발생")
    void createFile_NullName_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                new File(null, 1024));
    }

    @Test
    @DisplayName("빈 파일명으로 생성시 예외 발생")
    void createFile_EmptyName_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                new File("", 1024));
    }

    @Test
    @DisplayName("경로 구분자가 포함된 파일명으로 생성시 예외 발생")
    void createFile_InvalidCharacters_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                new File("test/file.txt", 1024));
        assertThrows(IllegalArgumentException.class, () ->
                new File("test\\file.txt", 1024));
    }

    @Test
    @DisplayName("음수 파일 크기로 생성시 예외 발생")
    void createFile_NegativeSize_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                new File("test.txt", -1));
    }

    @Test
    @DisplayName("파일명으로 검색 성공")
    void findByName_MatchingName_ReturnsFile() {
        // given
        File file = new File("test.txt", 1024);

        // when
        FileSystemComponent result = file.findByName("test.txt");

        // then
        assertEquals(file, result);
    }

    @Test
    @DisplayName("파일명으로 검색 실패")
    void findByName_NonMatchingName_ReturnsNull() {
        // given
        File file = new File("test.txt", 1024);

        // when
        FileSystemComponent result = file.findByName("other.txt");

        // then
        assertNull(result);
    }

    @Test
    @DisplayName("파일에 컴포넌트 추가시 예외 발생")
    void add_ToFile_ThrowsException() {
        // given
        File file = new File("test.txt", 1024);
        File otherFile = new File("other.txt", 512);

        // when & then
        assertThrows(UnsupportedOperationException.class, () ->
                file.add(otherFile));
    }
}