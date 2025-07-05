package me.sungbin.chapter.state;

public class PlayerStateChangeEvent {

    private final String previousState;

    private final String currentState;

    private final long timestamp;

    private final Song currentSong;

    public PlayerStateChangeEvent(String previousState, String currentState, Song currentSong) {
        this.previousState = previousState;
        this.currentState = currentState;
        this.currentSong = currentSong;
        this.timestamp = System.currentTimeMillis();
    }

    public String getPreviousState() {
        return previousState;
    }

    public String getCurrentState() {
        return currentState;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Song getCurrentSong() {
        return currentSong;
    }

    @Override
    public String toString() {
        return String.format("상태 변화: %s → %s (Song: %s)",
                previousState, currentState, currentSong != null ? currentSong.getTitle() : "None");
    }
}
