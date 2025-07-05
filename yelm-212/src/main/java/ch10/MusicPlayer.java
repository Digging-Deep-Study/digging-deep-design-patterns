package ch10;

import ch10.state.PlayerState;
import ch10.state.StoppedState;

// Context class
public class MusicPlayer {
    private PlayerState state;
    
    public MusicPlayer() {
        // initial state is stopped
        this.state = new StoppedState();
    }
    
    public void setState(PlayerState state) {
        this.state = state;
    }
    
    public void play() {
        state.play(this);
    }
    
    public void pause() {
        state.pause(this);
    }
    
    public void stop() {
        state.stop(this);
    }
}
