package ch09.composite;

public abstract class SystemComponent {

    public abstract void add(SystemComponent component);
    public abstract void remove(SystemComponent component);
    public abstract String getName();
    public abstract void display(String indent);
    public abstract int getSize();
}
