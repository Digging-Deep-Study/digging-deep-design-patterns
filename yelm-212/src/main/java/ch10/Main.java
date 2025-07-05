package ch10;

public class Main {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        
        System.out.println("=== Music Player State Pattern Test ===");
        
        player.play();   // play from stopped state
        player.pause();  // pause while playing
        player.play();   // resume from paused state
        player.stop();   // stop while playing
        player.play();   // play from stopped state
        player.stop();   // stop from stopped state
    }
}