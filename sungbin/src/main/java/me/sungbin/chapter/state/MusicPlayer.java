package me.sungbin.chapter.state;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MusicPlayer {

    private PlayerState currentState;
    private Song currentSong;
    private int currentPosition;
    private int volume;
    private final List<Song> playlist;
    private int currentTrackIndex;
    private final List<PlayerStateChangeListener> listeners;

    public MusicPlayer() {
        this.currentState = StoppedState.getInstance();
        this.volume = 50;
        this.currentPosition = 0;
        this.playlist = new ArrayList<>();
        this.currentTrackIndex = -1;
        this.listeners = new CopyOnWriteArrayList<>();
    }

    public PlayerState getCurrentState() {
        return currentState;
    }

    public Song getCurrentSong() {
        return currentSong;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getVolume() {
        return volume;
    }

    public List<Song> getPlaylist() {
        return new ArrayList<>(playlist);
    }

    public int getCurrentTrackIndex() {
        return currentTrackIndex;
    }

    public String getStateName() {
        return currentState.getStateName();
    }

    void setState(PlayerState newState) {
        if (newState == null) {
            throw new IllegalArgumentException("상태는 null일 수 없습니다");
        }

        String previousStateName = currentState.getStateName();
        this.currentState = newState;

        PlayerStateChangeEvent event = new PlayerStateChangeEvent(
                previousStateName, newState.getStateName(), currentSong);
        notifyStateChangeListeners(event);
    }

    public void play() {
        currentState.play(this);
    }

    public void pause() {
        currentState.pause(this);
    }

    public void stop() {
        currentState.stop(this);
    }

    public void addToPlaylist(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("음악은 null일 수 없습니다");
        }

        playlist.add(song);

        if (playlist.size() == 1) {
            currentTrackIndex = 0;
            currentSong = song;
        }
    }

    public void removeFromPlaylist(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("음악은 null일 수 없습니다");
        }

        int removedIndex = playlist.indexOf(song);
        if (removedIndex == -1) {
            throw new IllegalArgumentException("플레이리스트에서 음악을 찾을 수 없습니다");
        }

        playlist.remove(song);

        if (removedIndex == currentTrackIndex) {
            if (playlist.isEmpty()) {
                currentSong = null;
                currentTrackIndex = -1;
                setState(StoppedState.getInstance());
            } else {
                if (currentTrackIndex >= playlist.size()) {
                    currentTrackIndex = playlist.size() - 1;
                }
                currentSong = playlist.get(currentTrackIndex);
            }
        } else if (removedIndex < currentTrackIndex) {
            currentTrackIndex--;
        }
    }

    public void selectTrack(int index) {
        if (index < 0 || index >= playlist.size()) {
            throw new IndexOutOfBoundsException("유효하지 않은 트랙 인덱스: " + index);
        }

        currentTrackIndex = index;
        currentSong = playlist.get(index);
        currentPosition = 0;

        notifyMessage("곡이 선택되었습니다: " + currentSong.getTitle());
    }

    public void nextTrack() {
        if (playlist.isEmpty()) {
            notifyMessage("플레이리스트가 비어있습니다.");
            return;
        }

        if (currentTrackIndex < playlist.size() - 1) {
            selectTrack(currentTrackIndex + 1);
        } else {
            notifyMessage("마지막 곡입니다.");
        }
    }

    public void previousTrack() {
        if (playlist.isEmpty()) {
            notifyMessage("플레이리스트가 비어있습니다.");
            return;
        }

        if (currentTrackIndex > 0) {
            selectTrack(currentTrackIndex - 1);
        } else {
            notifyMessage("첫 번째 곡입니다.");
        }
    }

    public void setVolume(int volume) {
        if (volume < 0 || volume > 100) {
            throw new IllegalArgumentException("볼륨은 0과 100 사이여야 합니다");
        }
        this.volume = volume;
        notifyMessage("볼륨이 " + volume + "%로 설정되었습니다.");
    }

    public void volumeUp() {
        setVolume(Math.min(100, volume + 10));
    }

    public void volumeDown() {
        setVolume(Math.max(0, volume - 10));
    }

    public void seekTo(int positionSeconds) {
        if (currentSong == null) {
            throw new IllegalStateException("현재 선택된 음악이 없습니다");
        }
        if (positionSeconds < 0 || positionSeconds > currentSong.getDurationSeconds()) {
            throw new IllegalArgumentException("유효하지 않은 재생 위치입니다");
        }
        this.currentPosition = positionSeconds;
        notifyMessage("재생 위치가 " + formatTime(positionSeconds) + "로 이동되었습니다.");
    }

    void setCurrentPosition(int position) {
        this.currentPosition = Math.max(0, position);
    }

    public void addStateChangeListener(PlayerStateChangeListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("리스너는 null일 수 없습니다");
        }
        listeners.add(listener);
    }

    public void removeStateChangeListener(PlayerStateChangeListener listener) {
        listeners.remove(listener);
    }

    private void notifyStateChangeListeners(PlayerStateChangeEvent event) {
        listeners.forEach(listener -> {
            try {
                listener.onStateChanged(event);
            } catch (Exception e) {
                System.err.println("리스너 알림 중 오류 발생: " + e.getMessage());
            }
        });
    }

    void notifyMessage(String message) {
        System.out.println("[MusicPlayer] " + message);
    }

    public void displayStatus() {
        System.out.println("\n뮤직 플레이어 상태");
        System.out.println("--------------------------------------------");
        System.out.println("상태: " + currentState.getStateName());
        System.out.println("볼륨: " + volume + "%");

        if (currentSong != null) {
            System.out.println("현재 곡: " + currentSong);
            System.out.println("재생 위치: " + formatTime(currentPosition) + " / " + currentSong.getFormattedDuration());
            System.out.println("트랙 번호: " + (currentTrackIndex + 1) + " / " + playlist.size());
        } else {
            System.out.println("현재 곡: 없음");
        }

        System.out.println("플레이리스트: " + playlist.size() + "곡");
        System.out.println("--------------------------------------------");

        System.out.print("가능한 동작: ");
        List<String> actions = new ArrayList<>();
        if (currentState.canPlay()) actions.add("재생");
        if (currentState.canPause()) actions.add("일시정지");
        if (currentState.canStop()) actions.add("정지");
        System.out.println(String.join(", ", actions));
    }

    public void displayPlaylist() {
        System.out.println("\n📋 Playlist");
        System.out.println("--------------------------------------------");
        if (playlist.isEmpty()) {
            System.out.println("플레이리스트가 비어있습니다.");
        } else {
            for (int i = 0; i < playlist.size(); i++) {
                String marker = (i == currentTrackIndex) ? " " : "   ";
                System.out.printf("%s%d. %s%n", marker, i + 1, playlist.get(i));
            }
        }
        System.out.println("--------------------------------------------");
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        return String.format("%d:%02d", minutes, secs);
    }
}
