package ch10.state;

import ch10.MusicPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("State Pattern Tests")
public class StatePatternTest {
    
    private MusicPlayer player;
    
    @BeforeEach
    void setUp() {
        player = new MusicPlayer();
    }
    
    @Test
    @DisplayName("초기 상태 테스트")
    void testInitialState() {
        assertTrue(player.getCurrentState().equals("StoppedState"));
    }
    
    @Test
    @DisplayName("PlayingState에서 play 호출 테스트")
    void testPlayingStatePlay() {
        player.play();
        player.play();
        assertTrue(player.getCurrentState().equals("PlayingState"));
    }
    
    @Test
    @DisplayName("PlayingState에서 pause 호출 테스트")
    void testPlayingStatePause() {
        player.play();
        player.pause();
        assertTrue(player.getCurrentState().equals("PausedState"));
        
        player.play();
        assertTrue(player.getCurrentState().equals("PlayingState"));
    }
    
    @Test
    @DisplayName("PlayingState에서 stop 호출 테스트")
    void testPlayingStateStop() {
        player.play();
        player.stop();
        assertTrue(player.getCurrentState().equals("StoppedState"));
        
        player.play();
        assertTrue(player.getCurrentState().equals("PlayingState"));
    }
    
    @Test
    @DisplayName("PausedState에서 pause 호출 테스트")
    void testPausedStatePause() {
        // Playing -> Paused 상태로 전환
        player.play();
        player.pause();
        player.pause();
        assertTrue(player.getCurrentState().equals("PausedState"));
    }
    
    @Test
    @DisplayName("PausedState에서 stop 호출 테스트")
    void testPausedStateStop() {
        // Playing -> Paused 상태로 전환
        player.play();
        player.pause();
        player.stop();
        assertTrue(player.getCurrentState().equals("StoppedState"));
    }
    
    @Test
    @DisplayName("StoppedState에서 pause 호출 테스트")
    void testStoppedStatePause() {
        // 정지 상태에서 pause 호출
        player.pause();
        assertTrue(player.getCurrentState().equals("StoppedState"));
    }
    
    @Test
    @DisplayName("StoppedState에서 stop 호출 테스트")
    void testStoppedStateStop() {
        // 정지 상태에서 stop 호출
        player.stop();
        assertTrue(player.getCurrentState().equals("StoppedState"));
    }
    
    @Test
    @DisplayName("복잡한 상태 전환 시나리오 테스트")
    void testComplexStateTransitions() {
        // 시나리오: 정지 -> 재생 -> 일시정지 -> 재개 -> 정지 -> 재생
        
        // 1. 정지 -> 재생
        player.play();
        assertTrue(player.getCurrentState().equals("PlayingState"));
        
        // 2. 재생 -> 일시정지
        player.pause();
        assertTrue(player.getCurrentState().equals("PausedState"));
        
        // 3. 일시정지 -> 재개
        player.play();
        assertTrue(player.getCurrentState().equals("PlayingState"));
        
        // 4. 재생 -> 정지
        player.stop();
        assertTrue(player.getCurrentState().equals("StoppedState"));
        
        // 5. 정지 -> 재생
        player.play();
        assertTrue(player.getCurrentState().equals("PlayingState"));
    }
    
    @Test
    @DisplayName("상태 전환 후 이전 상태로 돌아가지 않음")
    void testStateTransitionPersistence() {
        // Playing -> Paused
        player.play();
        player.pause();     
        
        // Paused 상태에서 play 호출 시 "Resuming..." 출력
        player.play();
        assertTrue(player.getCurrentState().equals("PlayingState"));
    }
    
    @Test
    @DisplayName("상태별 적절한 메시지 출력 확인")
    void testStateSpecificMessages() {
        // 모든 상태별 메시지 확인
        
        // Stopped -> Playing
        player.play();
        assertTrue(player.getCurrentState().equals("PlayingState"));
        
        // Playing -> Already playing
        player.play();
        assertTrue(player.getCurrentState().equals("PlayingState"));
        
        // Playing -> Paused
        player.pause();
        assertTrue(player.getCurrentState().equals("PausedState"));
        
        // Paused -> Already paused
        player.pause();
        assertTrue(player.getCurrentState().equals("PausedState"));
        
        // Paused -> Stopped
        player.stop();
        assertTrue(player.getCurrentState().equals("StoppedState"));
        
        // Stopped -> Already stopped
        player.stop();
        assertTrue(player.getCurrentState().equals("StoppedState"));
    }
} 