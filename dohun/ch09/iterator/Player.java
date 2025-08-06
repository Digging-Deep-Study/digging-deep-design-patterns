package ch09.iterator;

import ch09.iterator.item.ConsumptionItem;
import ch09.iterator.item.EquipmentItem;
import ch09.iterator.item.QuestItem;

public class Player {
    public static void main(String[] args) {

        EquipmentItem equipmentItem = new EquipmentItem("냉동 참치", "냄비 뚜껑", "세계의 돼지도감", "물고기 작살");
        ConsumptionItem consumptionItem = new ConsumptionItem("빨간 포션", "파란 포션", "호빵", "파워 엘릭서");
        QuestItem questItem = new QuestItem("돼지와 함께 춤을 땅문서", "아르웬의 유리구두", "나사", "동물의 가죽");

        Inventory inventory = new Inventory(equipmentItem, consumptionItem, questItem);
        inventory.printItems();
    }
}
