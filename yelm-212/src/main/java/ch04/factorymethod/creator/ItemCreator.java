package ch04.factorymethod.creator;

import ch04.factorymethod.item.Item;

public abstract class ItemCreator {
    public abstract Item createItem(String type);

    public final Item requestItem(String type) {
        Item item = createItem(type);
        // 아이템 생성 후 공통 로직
        System.out.println("아이템 생성 완료: " + item.getName());
        return item;
    }
} 