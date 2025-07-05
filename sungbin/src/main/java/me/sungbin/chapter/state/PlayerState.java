package me.sungbin.chapter.state;

public interface PlayerState {

    void play(MusicPlayer context);

    void pause(MusicPlayer context);

    void stop(MusicPlayer context);

    String getStateName();

    boolean canPlay();

    boolean canPause();

    boolean canStop();
}
