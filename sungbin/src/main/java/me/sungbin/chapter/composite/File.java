package me.sungbin.chapter.composite;

import java.util.Objects;

public class File extends FileSystemComponent {

    private final long size;

    private final String extension;

    public File(String name, long size) {
        super(name);
        this.size = validateSize(size);
        this.extension = extractExtension(name);
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void display(String indent) {
        System.out.printf("%s %s (%s)%n",
                indent, name, formatFileSize(size));
    }

    @Override
    public FileSystemComponent findByName(String name) {
        return this.name.equals(name) ? this : null;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        File file = (File) obj;
        return size == file.size &&
                name.equals(file.name) &&
                createdAt == file.createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, createdAt);
    }

    private String formatFileSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024));
        return String.format("%.1f GB", bytes / (1024.0 * 1024 * 1024));
    }

    private long validateSize(long size) {
        if (size < 0) {
            throw new IllegalArgumentException("파일 사이즈는 음수일 수 없습니다.");
        }
        return size;
    }

    private String extractExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        return lastDotIndex > 0 ? fileName.substring(lastDotIndex + 1).toLowerCase() : "";
    }
}
