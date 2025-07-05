package me.sungbin.chapter.composite;

import java.util.List;

public abstract class FileSystemComponent {

    protected final String name;
    protected final long createdAt;

    protected FileSystemComponent(String name) {
        this.name = validateName(name);
        this.createdAt = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("잘못된 이름입니다.");
        }
        if (name.contains("/") || name.contains("\\")) {
            throw new IllegalArgumentException("이름에 구분자가 포함되어있습니다.");
        }
        return name.trim();
    }

    public abstract long getSize();

    public abstract void display(String indent);

    public abstract FileSystemComponent findByName(String name);

    public abstract boolean isDirectory();

    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("파일을 추가할 수 없습니다.");
    }

    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("파일을 삭제할 수 없습니다.");
    }

    public List<FileSystemComponent> getChildren() {
        throw new UnsupportedOperationException("파일들은 하위 계층이 없습니다.");
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, isDirectory() ? "Directory" : "File");
    }
}
