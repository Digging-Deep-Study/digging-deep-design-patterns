package ch04.factorymethod;

import ch04.factorymethod.creator.ItemCreator;
import ch04.factorymethod.creator.WeaponCreator;
import ch04.factorymethod.creator.ArmorCreator;
import ch04.factorymethod.item.Item;

public class Main {
    public static void main(String[] args) {
        // 무기 생성
        ItemCreator weaponCreator = new WeaponCreator();
        Item sword = weaponCreator.requestItem("sword");
        Item bow = weaponCreator.requestItem("bow");

        // 방어구 생성
        ItemCreator armorCreator = new ArmorCreator();
        Item plateArmor = armorCreator.requestItem("plate");
        Item leatherArmor = armorCreator.requestItem("leather");

        // 아이템 사용
        sword.use();
        bow.use();
        plateArmor.use();
        leatherArmor.use();
    }
}
