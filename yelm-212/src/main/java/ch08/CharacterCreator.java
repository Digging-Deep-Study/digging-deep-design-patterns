package ch08;

import java.util.ArrayList;
import java.util.List;

public abstract class CharacterCreator {
    public final Character createCharacter(String name, int age) {
        Character character = new Character(name, age);

        setJob(character);
        setSkill(character);
        setEquipment(character);
        return character;
    }

    abstract void setJob(Character character);
    abstract void setSkill(Character character);
    abstract void setEquipment(Character character);

}

class Warrior extends CharacterCreator {
    @Override
    void setJob(Character character) {
        character.setJob("Warrior");
    }

    @Override
    void setSkill(Character character) {
        List<String> skills = new ArrayList<>();
        skills.add("Warrior skill");
        character.setSkills(skills);
    }

    @Override
    void setEquipment(Character character) {
        character.setEquipment("Sword");
    }
}

class Wizard extends CharacterCreator {

    @Override
    void setJob(Character character) {
        character.setJob("Wizard");
    }

    @Override
    void setSkill(Character character) {
        List<String> skills = new ArrayList<>();
        skills.add("Wizard skill");
        character.setSkills(skills);
    }

    @Override
    void setEquipment(Character character) {
        character.setEquipment("Spellbook");
    }
}