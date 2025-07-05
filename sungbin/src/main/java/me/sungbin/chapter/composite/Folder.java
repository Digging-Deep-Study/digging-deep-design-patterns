package me.sungbin.chapter.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class Folder extends FileSystemComponent {

    private final List<FileSystemComponent> children;

    public Folder(String name) {
        super(name);
        this.children = new CopyOnWriteArrayList<>();
    }

    @Override
    public void add(FileSystemComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("잘못된 값을 가진 컴포넌트입니다.");
        }
        if (component == this) {
            throw new IllegalArgumentException("자기 자신을 추가할 수 없습니다.");
        }
        if (isDuplicateName(component.getName())) {
            throw new IllegalArgumentException("'" + component.getName() + "'의 컴포넌트는 이미 존재합니다.");
        }
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("잘못된 값을 가진 컴포넌트입니다.");
        }
        boolean removed = children.remove(component);
        if (!removed) {
            throw new IllegalArgumentException("해당 폴더에 컴포넌트를 찾을 수 없습니다.");
        }
    }

    @Override
    public List<FileSystemComponent> getChildren() {
        return new ArrayList<>(children);
    }

    @Override
    public long getSize() {
        return children.stream()
                .mapToLong(FileSystemComponent::getSize)
                .sum();
    }

    @Override
    public void display(String indent) {
        System.out.printf("%s %s/ (%d items, %s)%n",
                indent, name, children.size(), formatFileSize(getSize()));

        children.forEach(child -> child.display(indent + "  "));
    }

    @Override
    public FileSystemComponent findByName(String name) {
        if (this.name.equals(name)) {
            return this;
        }

        return children.stream()
                .map(child -> child.findByName(name))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public int getChildCount() {
        return children.size();
    }

    public boolean isEmpty() {
        return children.isEmpty();
    }

    public List<File> getAllFiles() {
        List<File> allFiles = new ArrayList<>();
        collectFiles(allFiles);
        return allFiles;
    }

    private void collectFiles(List<File> fileList) {
        for (FileSystemComponent child : children) {
            if (child instanceof File) {
                fileList.add((File) child);
            } else if (child instanceof Folder) {
                ((Folder) child).collectFiles(fileList);
            }
        }
    }

    public List<Folder> getAllFolders() {
        List<Folder> allFolders = new ArrayList<>();
        collectFolders(allFolders);
        return allFolders;
    }

    private void collectFolders(List<Folder> folderList) {
        for (FileSystemComponent child : children) {
            if (child instanceof Folder folder) {
                folderList.add(folder);
                folder.collectFolders(folderList);
            }
        }
    }

    private boolean isDuplicateName(String name) {
        return children.stream()
                .anyMatch(child -> child.getName().equals(name));
    }

    private String formatFileSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024));
        return String.format("%.1f GB", bytes / (1024.0 * 1024 * 1024));
    }
}
