package me.sungbin.chapter.state;

public class StoppedState implements PlayerState {

    private static final StoppedState INSTANCE = new StoppedState();

    private StoppedState() {
    }

    public static StoppedState getInstance() {
        return INSTANCE;
    }

    @Override
    public void play(MusicPlayer context) {
        if (context.getCurrentSong() == null) {
            context.notifyMessage("재생할 음악이 없습니다.");
            return;
        }

        context.notifyMessage("재생을 시작합니다: " + context.getCurrentSong().getTitle());
        context.setCurrentPosition(0);
        context.setState(PlayingState.getInstance());
    }

    @Override
    public void pause(MusicPlayer context) {
        context.notifyMessage("정지된 상태에서는 일시정지할 수 없습니다.");
    }

    @Override
    public void stop(MusicPlayer context) {
        context.notifyMessage("이미 정지된 상태입니다.");
    }

    @Override
    public String getStateName() {
        return "정지됨";
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
        return false;
    }
}
