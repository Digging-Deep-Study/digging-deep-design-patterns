package ch14.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private final Map<String, CharacterFlyweight> pool = new HashMap<>();

    public CharacterFlyweight getCharacter(char value, String font, int size) {
        String key = createKey(value, font, size);
        return pool.computeIfAbsent(key, k -> new CharacterFlyweight(value, font, size));
    }

    private String createKey(char value, String font, int size) {
        return value + "_" + font + "_" + size;
    }
}
