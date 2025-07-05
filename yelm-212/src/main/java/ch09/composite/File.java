package ch09.composite;

public class File extends SystemComponent {
    private String name;
    private String content;

    public File(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public void add(SystemComponent component) {
        throw new UnsupportedOperationException("File cannot add component");
    }

    @Override
    public void remove(SystemComponent component) {
        throw new UnsupportedOperationException("File cannot remove component");
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- " + name + " (" + getSize() + " bytes)");
    }

    @Override
    public int getSize() {
        return content != null ? content.length() : 0;
    }
}
