package me.sungbin.chapter.state;

public class Main {

    public static void main(String[] args) {
        MusicPlayer player = createSampleMusicPlayer();

        player.addStateChangeListener(event -> System.out.println(" " + event));

        player.displayStatus();
        player.displayPlaylist();

        demonstratePlayerStates(player);
    }

    private static MusicPlayer createSampleMusicPlayer() {
        MusicPlayer player = new MusicPlayer();

        player.addToPlaylist(new Song("Imagine", "John Lennon", 183, "Imagine"));
        player.addToPlaylist(new Song("Bohemian Rhapsody", "Queen", 355, "A Night at the Opera"));
        player.addToPlaylist(new Song("Hotel California", "Eagles", 391, "Hotel California"));
        player.addToPlaylist(new Song("Stairway to Heaven", "Led Zeppelin", 482, "Led Zeppelin IV"));
        player.addToPlaylist(new Song("Yesterday", "The Beatles", 125, "Help!"));

        return player;
    }

    private static void demonstratePlayerStates(MusicPlayer player) {
        System.out.println("\n 데모");
        System.out.println("═══════════════════════════════");

        System.out.println("\n 1. 정지 상태에서의 동작들:");
        player.pause();
        player.stop();
        player.play();

        System.out.println("\n 2. 재생 상태에서의 동작들:");
        player.play();
        player.pause();

        System.out.println("\n 3. 일시정지 상태에서의 동작들:");
        player.pause();
        player.play();
        player.stop();

        System.out.println("\n 4. 추가 기능 테스트:");
        player.setVolume(75);
        player.nextTrack();
        player.play();
        player.seekTo(30);

        System.out.println("\n 최종 상태:");
        player.displayStatus();
    }
}
