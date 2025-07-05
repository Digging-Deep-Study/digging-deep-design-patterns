package ch10.state;

import ch10.MusicPlayer;

// Paused state
public class PausedState implements PlayerState {
    @Override
    public void play(MusicPlayer player) {
        System.out.println("Resuming...");
        player.setState(new PlayingState());
    }
    
    @Override
    public void pause(MusicPlayer player) {
        System.out.println("Already paused...");
    }
    
    @Override
    public void stop(MusicPlayer player) {
        System.out.println("Stopping...");
        player.setState(new StoppedState());
    }
}
