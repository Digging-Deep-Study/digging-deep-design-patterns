package ch07.facade;

public class MediaPlayer {
    private AudioPlayer audioPlayer;
    private VideoPlayer videoPlayer;
    private SubtitlePlayer subtitlePlayer;

    public MediaPlayer() {
        audioPlayer = new AudioPlayer();
        videoPlayer = new VideoPlayer();
        subtitlePlayer = new SubtitlePlayer();
    }

    public void play() {
        audioPlayer.playAudio();
        videoPlayer.playVideo();
        subtitlePlayer.displaySubtitle();
    }

}

class AudioPlayer {
    public void playAudio() {
        System.out.println("Playing audio");
    }
}

class VideoPlayer {
    public void playVideo() {
        System.out.println("Playing video");
    }
}

class SubtitlePlayer {
    public void displaySubtitle() {
        System.out.println("Displaying subtitle");
    }
}