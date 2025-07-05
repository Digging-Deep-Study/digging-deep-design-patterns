package me.sungbin.chapter.state;

import java.util.Objects;

public class Song {

    private final String title;

    private final String artist;

    private final int durationSeconds;

    private final String album;

    public Song(String title, String artist, int durationSeconds, String album) {
        this.title = validateString(title, "Title");
        this.artist = validateString(artist, "Artist");
        this.durationSeconds = validateDuration(durationSeconds);
        this.album = validateString(album, "Album");
    }

    public Song(String title, String artist, int durationSeconds) {
        this(title, artist, durationSeconds, "알 수 없는 앨범");
    }

    private String validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + "은(는) null이거나 빈 값일 수 없습니다");
        }
        return value.trim();
    }

    private int validateDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("재생 시간은 양수여야 합니다");
        }
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public String getAlbum() {
        return album;
    }

    public String getFormattedDuration() {
        int minutes = durationSeconds / 60;
        int seconds = durationSeconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", title, artist, getFormattedDuration());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Song song = (Song) obj;
        return durationSeconds == song.durationSeconds &&
                title.equals(song.title) &&
                artist.equals(song.artist) &&
                album.equals(song.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, durationSeconds, album);
    }
}
