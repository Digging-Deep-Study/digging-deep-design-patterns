package ch04.factorymethod.item;

public class Weapon implements Item {
    private String name;
    private int level;
    private int damage;

    public Weapon(String name, int level, int damage) {
        this.name = name;
        this.level = level;
        this.damage = damage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Weapon";
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void use() {
        System.out.println(name + " 무기로 공격! 데미지: " + damage);
    }
} 