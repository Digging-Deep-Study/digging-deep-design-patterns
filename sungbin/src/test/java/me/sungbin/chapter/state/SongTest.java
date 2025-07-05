package me.sungbin.chapter.state;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    @DisplayName("유효한 정보로 음악 생성")
    void createSong_ValidParameters_Success() {
        // given
        String title = "Test Song";
        String artist = "Test Artist";
        int duration = 180;
        String album = "Test Album";

        // when
        Song song = new Song(title, artist, duration, album);

        // then
        assertEquals(title, song.getTitle());
        assertEquals(artist, song.getArtist());
        assertEquals(duration, song.getDurationSeconds());
        assertEquals(album, song.getAlbum());
        assertEquals("3:00", song.getFormattedDuration());
    }

    @Test
    @DisplayName("앨범명 없이 음악 생성")
    void createSong_WithoutAlbum_Success() {
        // given
        String title = "Test Song";
        String artist = "Test Artist";
        int duration = 125;

        // when
        Song song = new Song(title, artist, duration);

        // then
        assertEquals("알 수 없는 앨범", song.getAlbum());
        assertEquals("2:05", song.getFormattedDuration());
    }

    @Test
    @DisplayName("null 제목으로 음악 생성시 예외 발생")
    void createSong_NullTitle_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                new Song(null, "Artist", 180));
    }

    @Test
    @DisplayName("빈 제목으로 음악 생성시 예외 발생")
    void createSong_EmptyTitle_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                new Song("", "Artist", 180));
    }

    @Test
    @DisplayName("음수 재생시간으로 음악 생성시 예외 발생")
    void createSong_NegativeDuration_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                new Song("Title", "Artist", -1));
    }

    @Test
    @DisplayName("0초 재생시간으로 음악 생성시 예외 발생")
    void createSong_ZeroDuration_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                new Song("Title", "Artist", 0));
    }
}