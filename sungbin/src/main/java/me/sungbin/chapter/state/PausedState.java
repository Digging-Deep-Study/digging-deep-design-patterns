package me.sungbin.chapter.state;

public class PausedState implements PlayerState {

    private static final PausedState INSTANCE = new PausedState();

    private PausedState() {
    }

    public static PausedState getInstance() {
        return INSTANCE;
    }

    @Override
    public void play(MusicPlayer context) {
        context.notifyMessage("재생을 재개합니다: " + context.getCurrentSong().getTitle());
        context.setState(PlayingState.getInstance());
    }

    @Override
    public void pause(MusicPlayer context) {
        context.notifyMessage("이미 일시정지된 상태입니다.");
    }

    @Override
    public void stop(MusicPlayer context) {
        context.notifyMessage("재생을 정지합니다.");
        context.setCurrentPosition(0);
        context.setState(StoppedState.getInstance());
    }

    @Override
    public String getStateName() {
        return "일시정지";
    }

    @Override
    public boolean canPlay() {
        return true;
    }

    @Override
    public boolean canPause() {
        return false;
    }

    @Override
    public boolean canStop() {
        return true;
    }
}
