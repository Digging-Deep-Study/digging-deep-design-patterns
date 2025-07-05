package ch10.state;

import ch10.MusicPlayer;

// Playing state
public class PlayingState implements PlayerState {
    @Override
    public void play(MusicPlayer player) {
        System.out.println("Already playing...");
    }
    
    @Override
    public void pause(MusicPlayer player) {
        System.out.println("Pausing...");
        player.setState(new PausedState());
    }
    
    @Override
    public void stop(MusicPlayer player) {
        System.out.println("Stopping...");
        player.setState(new StoppedState());
    }
}
