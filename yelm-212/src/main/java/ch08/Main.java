package ch08;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Template Method Pattern Test ===\n");
        
        // Create warrior character
        CharacterCreator warriorCreator = new Warrior();
        Character warrior = warriorCreator.createCharacter("Arthur", 25);
        
        System.out.println("Warrior Character Created:");
        System.out.println("Name: " + warrior.getName());
        System.out.println("Age: " + warrior.getAge());
        System.out.println("Job: " + warrior.getJob());
        System.out.println("Skills: " + warrior.getSkills());
        System.out.println("Equipment: " + warrior.getEquipment());
        System.out.println();
        
        // Create wizard character
        CharacterCreator wizardCreator = new Wizard();
        Character wizard = wizardCreator.createCharacter("Gandalf", 30);
        
        System.out.println("Wizard Character Created:");
        System.out.println("Name: " + wizard.getName());
        System.out.println("Age: " + wizard.getAge());
        System.out.println("Job: " + wizard.getJob());
        System.out.println("Skills: " + wizard.getSkills());
        System.out.println("Equipment: " + wizard.getEquipment());
        System.out.println();
    }
}
