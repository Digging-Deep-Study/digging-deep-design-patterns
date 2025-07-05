package me.sungbin.chapter.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicPlayerTest {

    private MusicPlayer player;

    private Song song1;

    private Song song2;

    @BeforeEach
    void setUp() {
        player = new MusicPlayer();
        song1 = new Song("Song 1", "Artist 1", 180);
        song2 = new Song("Song 2", "Artist 2", 240);
    }

    @Test
    @DisplayName("새로운 플레이어 생성시 정지 상태")
    void newPlayer_InitialState_IsStopped() {
        // given & when & then
        assertEquals("정지됨", player.getStateName());
        assertEquals(50, player.getVolume()); // 기본 볼륨
        assertEquals(0, player.getCurrentPosition());
        assertNull(player.getCurrentSong());
    }

    @Test
    @DisplayName("플레이리스트에 음악 추가")
    void addToPlaylist_ValidSong_Success() {
        // given & when
        player.addToPlaylist(song1);

        // then
        assertEquals(1, player.getPlaylist().size());
        assertEquals(song1, player.getCurrentSong());
        assertEquals(0, player.getCurrentTrackIndex());
    }

    @Test
    @DisplayName("null 음악을 플레이리스트에 추가시 예외 발생")
    void addToPlaylist_NullSong_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                player.addToPlaylist(null));
    }

    @Test
    @DisplayName("플레이리스트에서 음악 제거")
    void removeFromPlaylist_ExistingSong_Success() {
        // given
        player.addToPlaylist(song1);
        player.addToPlaylist(song2);

        // when
        player.removeFromPlaylist(song1);

        // then
        assertEquals(1, player.getPlaylist().size());
        assertEquals(song2, player.getCurrentSong());
        assertEquals(0, player.getCurrentTrackIndex());
    }

    @Test
    @DisplayName("존재하지 않는 음악 제거시 예외 발생")
    void removeFromPlaylist_NonExistingSong_ThrowsException() {
        // given
        player.addToPlaylist(song1);

        // when & then
        assertThrows(IllegalArgumentException.class, () ->
                player.removeFromPlaylist(song2));
    }

    @Test
    @DisplayName("볼륨 설정")
    void setVolume_ValidRange_Success() {
        // given & when
        player.setVolume(75);

        // then
        assertEquals(75, player.getVolume());
    }

    @Test
    @DisplayName("유효하지 않은 볼륨 설정시 예외 발생")
    void setVolume_InvalidRange_ThrowsException() {
        // given & when & then
        assertThrows(IllegalArgumentException.class, () ->
                player.setVolume(-1));
        assertThrows(IllegalArgumentException.class, () ->
                player.setVolume(101));
    }

    @Test
    @DisplayName("볼륨 증가/감소")
    void volumeUpDown_ValidRange_Success() {
        // given
        player.setVolume(50);

        // when
        player.volumeUp();
        // then
        assertEquals(60, player.getVolume());

        // when
        player.volumeDown();
        // then
        assertEquals(50, player.getVolume());
    }

    @Test
    @DisplayName("트랙 선택")
    void selectTrack_ValidIndex_Success() {
        // given
        player.addToPlaylist(song1);
        player.addToPlaylist(song2);

        // when
        player.selectTrack(1);

        // then
        assertEquals(1, player.getCurrentTrackIndex());
        assertEquals(song2, player.getCurrentSong());
        assertEquals(0, player.getCurrentPosition());
    }

    @Test
    @DisplayName("유효하지 않은 트랙 선택시 예외 발생")
    void selectTrack_InvalidIndex_ThrowsException() {
        // given
        player.addToPlaylist(song1);

        // when & then
        assertThrows(IndexOutOfBoundsException.class, () ->
                player.selectTrack(-1));
        assertThrows(IndexOutOfBoundsException.class, () ->
                player.selectTrack(1));
    }

    @Test
    @DisplayName("다음/이전 트랙 이동")
    void nextPreviousTrack_ValidRange_Success() {
        // given
        player.addToPlaylist(song1);
        player.addToPlaylist(song2);

        // when
        player.nextTrack();

        // then
        assertEquals(1, player.getCurrentTrackIndex());
        assertEquals(song2, player.getCurrentSong());

        // when
        player.previousTrack();

        // then
        assertEquals(0, player.getCurrentTrackIndex());
        assertEquals(song1, player.getCurrentSong());
    }

    @Test
    @DisplayName("재생 위치 이동")
    void seekTo_ValidPosition_Success() {
        // given
        player.addToPlaylist(song1);

        // when
        player.seekTo(30);

        // then
        assertEquals(30, player.getCurrentPosition());
    }

    @Test
    @DisplayName("현재 음악이 없을 때 재생 위치 이동시 예외 발생")
    void seekTo_NoCurrentSong_ThrowsException() {
        // given & when & then
        assertThrows(IllegalStateException.class, () ->
                player.seekTo(30));
    }

    @Test
    @DisplayName("상태 변경 리스너 테스트")
    void stateChangeListener_StateChange_NotifiesListener() {
        // given
        player.addToPlaylist(song1);
        final PlayerStateChangeEvent[] capturedEvent = new PlayerStateChangeEvent[1];

        player.addStateChangeListener(event -> capturedEvent[0] = event);

        // when
        player.play();

        // then
        assertNotNull(capturedEvent[0]);
        assertEquals("정지됨", capturedEvent[0].getPreviousState());
        assertEquals("재생 중", capturedEvent[0].getCurrentState());
        assertEquals(song1, capturedEvent[0].getCurrentSong());
    }
}