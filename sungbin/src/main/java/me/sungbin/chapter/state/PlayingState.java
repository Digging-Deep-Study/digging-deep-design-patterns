package me.sungbin.chapter.state;

public class PlayingState implements PlayerState {

    private static final PlayingState INSTANCE = new PlayingState();

    private PlayingState() {
    }

    public static PlayingState getInstance() {
        return INSTANCE;
    }

    @Override
    public void play(MusicPlayer context) {
        context.notifyMessage("ℹ️ 이미 재생 중입니다: " + context.getCurrentSong().getTitle());
    }

    @Override
    public void pause(MusicPlayer context) {
        context.notifyMessage("재생을 일시정지합니다.");
        context.setState(PausedState.getInstance());
    }

    @Override
    public void stop(MusicPlayer context) {
        context.notifyMessage("⏹️ 재생을 정지합니다.");
        context.setCurrentPosition(0);
        context.setState(StoppedState.getInstance());
    }

    @Override
    public String getStateName() {
        return "재생 중";
    }

    @Override
    public boolean canPlay() {
        return false;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canStop() {
        return true;
    }
}
