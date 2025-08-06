package ch14.flyweight;

public class CharacterFlyweight {
    private final char value;
    private final String font;
    private final int size;

    public CharacterFlyweight(char value, String font, int size) {
        this.value = value;
        this.font = font;
        this.size = size;
    }

    public void render(int x, int y) {
        System.out.println("Rendering character \"" + value + "\" at " + x + "," + y + " (font: " + font + ", size: " + size + ")");
    }
}
