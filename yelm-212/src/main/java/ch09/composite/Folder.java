package ch09.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends SystemComponent {
    private String name;
    private List<SystemComponent> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    @Override
    public void add(SystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(SystemComponent component) {
        children.remove(component);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "L " + name + " (" + children.size() + " items)");
        for (SystemComponent child : children) {
            child.display(indent + "  ");
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (SystemComponent child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    public List<SystemComponent> getChildren() {
        return new ArrayList<>(children);
    }
}
