package me.sungbin.chapter.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerStateTest {

    private MusicPlayer player;

    private Song testSong;

    @BeforeEach
    void setUp() {
        player = new MusicPlayer();
        testSong = new Song("Test Song", "Test Artist", 180);
        player.addToPlaylist(testSong);
    }

    @Test
    @DisplayName("정지 상태에서 재생 버튼 클릭시 재생 상태로 전환")
    void stoppedState_Play_TransitionsToPlaying() {
        // given
        assertEquals("정지됨", player.getStateName());

        // when
        player.play();

        // then
        assertEquals("재생 중", player.getStateName());
        assertEquals(0, player.getCurrentPosition());
    }

    @Test
    @DisplayName("정지 상태에서 일시정지 버튼 클릭시 상태 유지")
    void stoppedState_Pause_StaysInStopped() {
        // given
        assertEquals("정지됨", player.getStateName());

        // when
        player.pause();

        // then
        assertEquals("정지됨", player.getStateName());
    }

    @Test
    @DisplayName("재생 상태에서 일시정지 버튼 클릭시 일시정지 상태로 전환")
    void playingState_Pause_TransitionsToPaused() {
        // given
        player.play();
        assertEquals("재생 중", player.getStateName());

        // when
        player.pause();

        // then
        assertEquals("일시정지", player.getStateName());
    }

    @Test
    @DisplayName("재생 상태에서 정지 버튼 클릭시 정지 상태로 전환")
    void playingState_Stop_TransitionsToStopped() {
        // given
        player.play();
        assertEquals("재생 중", player.getStateName());

        // when
        player.stop();

        // then
        assertEquals("정지됨", player.getStateName());
        assertEquals(0, player.getCurrentPosition());
    }

    @Test
    @DisplayName("일시정지 상태에서 재생 버튼 클릭시 재생 상태로 전환")
    void pausedState_Play_TransitionsToPlaying() {
        // given
        player.play();
        player.pause();
        assertEquals("일시정지", player.getStateName());

        // when
        player.play();

        // then
        assertEquals("재생 중", player.getStateName());
    }

    @Test
    @DisplayName("일시정지 상태에서 정지 버튼 클릭시 정지 상태로 전환")
    void pausedState_Stop_TransitionsToStopped() {
        // given
        player.play();
        player.pause();
        assertEquals("일시정지", player.getStateName());

        // when
        player.stop();

        // then
        assertEquals("정지됨", player.getStateName());
        assertEquals(0, player.getCurrentPosition());
    }

    @Test
    @DisplayName("상태별 가능한 동작 확인")
    void states_CanPerformActions_ReturnsCorrectValues() {
        // given & when & then
        assertTrue(player.getCurrentState().canPlay());
        assertFalse(player.getCurrentState().canPause());
        assertFalse(player.getCurrentState().canStop());

        player.play();
        assertFalse(player.getCurrentState().canPlay());
        assertTrue(player.getCurrentState().canPause());
        assertTrue(player.getCurrentState().canStop());

        player.pause();
        assertTrue(player.getCurrentState().canPlay());
        assertFalse(player.getCurrentState().canPause());
        assertTrue(player.getCurrentState().canStop());
    }
}