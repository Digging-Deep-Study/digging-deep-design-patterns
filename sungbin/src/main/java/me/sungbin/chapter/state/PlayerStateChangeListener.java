package me.sungbin.chapter.state;

@FunctionalInterface
public interface PlayerStateChangeListener {
    void onStateChanged(PlayerStateChangeEvent event);
}
