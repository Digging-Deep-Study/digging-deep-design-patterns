package me.sungbin.chapter.composite;

public class FileSystemManager {

    private final Folder rootFolder;

    public FileSystemManager(String rootName) {
        this.rootFolder = new Folder(rootName);
    }

    public Folder getRootFolder() {
        return rootFolder;
    }

    public void displayFileSystem() {
        System.out.println("파일 시스템 구조:");
        System.out.println("=" + "=".repeat(50));
        rootFolder.display("");
        System.out.println("=" + "=".repeat(50));
    }

    public FileSystemComponent search(String name) {
        return rootFolder.findByName(name);
    }

    public long getTotalSize() {
        return rootFolder.getSize();
    }

    public int getTotalFileCount() {
        return rootFolder.getAllFiles().size();
    }

    public int getTotalFolderCount() {
        return rootFolder.getAllFolders().size() + 1;
    }

    public void printStatistics() {
        System.out.println("\n 파일 시스템 분석:");
        System.out.printf("총 사이즈: %s%n", formatFileSize(getTotalSize()));
        System.out.printf("총 파일 개수: %d%n", getTotalFileCount());
        System.out.printf("총 폴더 개수: %d%n", getTotalFolderCount());
    }

    private String formatFileSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024));
        return String.format("%.1f GB", bytes / (1024.0 * 1024 * 1024));
    }
}
