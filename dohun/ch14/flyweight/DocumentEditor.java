package ch14.flyweight;

public class DocumentEditor {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        CharacterFlyweight char1 = factory.getCharacter('A', "Arial", 12);
        CharacterFlyweight char2 = factory.getCharacter('B', "Arial", 12);
        CharacterFlyweight char3 = factory.getCharacter('A', "Arial", 12);

        char1.render(1, 1);
        char2.render(2, 2);
        char3.render(3, 3);
    }
}
