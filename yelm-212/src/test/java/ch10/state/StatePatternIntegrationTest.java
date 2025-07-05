package ch10.state;

import ch10.MusicPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("State Pattern Integration Tests")
public class StatePatternIntegrationTest {
    
    private MusicPlayer player;
    
    @BeforeEach
    void setUp() {
        player = new MusicPlayer();
    }
    
    @Test
    @DisplayName("전체 음악 플레이어 시나리오 테스트")
    void testCompleteMusicPlayerScenario() {
        // 시나리오: 음악 플레이어의 일반적인 사용 패턴
        
        // 1. 초기 상태 (정지)에서 재생 시작
        player.play();
        assertTrue(player.getCurrentState().equals("PlayingState"));
        
        // 2. 재생 중에 일시정지
        player.pause();
        assertTrue(player.getCurrentState().equals("PausedState"));
        
        // 3. 일시정지 상태에서 재개
        player.play();
        assertTrue(player.getCurrentState().equals("PlayingState"));
        
        // 4. 재생 중에 다시 일시정지
        player.pause();
        assertTrue(player.getCurrentState().equals("PausedState"));
        
        // 5. 일시정지 상태에서 정지
        player.stop();
        assertTrue(player.getCurrentState().equals("StoppedState"));
        
        // 6. 정지 상태에서 다시 재생
        player.play();
        assertTrue(player.getCurrentState().equals("PlayingState"));
        
        // 7. 재생 중에 정지
        player.stop();
        assertTrue(player.getCurrentState().equals("StoppedState"));
    }
    
    @Test
    @DisplayName("잘못된 상태 전환 시나리오 테스트")
    void testInvalidStateTransitions() {
        // 시나리오: 잘못된 상태에서의 동작 테스트
        
        // 1. 정지 상태에서 일시정지 시도
        player.pause();
        assertTrue(player.getCurrentState().equals("StoppedState"));
        
        // 2. 정지 상태에서 정지 시도
        player.stop();
        assertTrue(player.getCurrentState().equals("StoppedState"));
        
        // 3. 재생 상태에서 재생 시도
        player.play(); // 정지 -> 재생
        player.play(); // 재생 중 재생 시도
        assertTrue(player.getCurrentState().equals("PlayingState"));
        
        // 4. 일시정지 상태에서 일시정지 시도
        player.pause(); // 재생 -> 일시정지
        player.pause(); // 일시정지 중 일시정지 시도
        assertTrue(player.getCurrentState().equals("PausedState"));
    }

    
    @Test
    @DisplayName("상태 패턴의 격리성 테스트")
    void testStatePatternIsolation() {
        MusicPlayer player1 = new MusicPlayer();
        player1.play();
        player1.pause();
        
        // 두 번째 플레이어 (독립적이어야 함)
        MusicPlayer player2 = new MusicPlayer();
        player2.play();
        
        assertTrue(player1.getCurrentState().equals("PausedState"));
        assertTrue(player2.getCurrentState().equals("PlayingState"));
    }
} 