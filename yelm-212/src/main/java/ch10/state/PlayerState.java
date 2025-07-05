package ch10.state;

import ch10.MusicPlayer;

// State interface
public interface PlayerState {
    void play(MusicPlayer player);
    void pause(MusicPlayer player);
    void stop(MusicPlayer player);
}
