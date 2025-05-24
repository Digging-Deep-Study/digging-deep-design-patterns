package ch04.factorymethod.item;

public class Armor implements Item {
    private String name;
    private int level;
    private int defense;

    public Armor(String name, int level, int defense) {
        this.name = name;
        this.level = level;
        this.defense = defense;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Armor";
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void use() {
        System.out.println(name + " 방어구 착용! 방어력: " + defense);
    }
} 