package ch10.state;

import ch10.MusicPlayer;

// Stopped state
public class StoppedState implements PlayerState {
    @Override
    public void play(MusicPlayer player) {
        System.out.println("Playing...");
        player.setState(new PlayingState());
    }
    
    @Override
    public void pause(MusicPlayer player) {
        System.out.println("Cannot pause from stopped state...");
    }
    
    @Override
    public void stop(MusicPlayer player) {
        System.out.println("Already stopped...");
    }
}
