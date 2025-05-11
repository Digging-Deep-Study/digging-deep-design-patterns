package ch02.monitoring;

import java.util.ArrayList;
import java.util.List;

public class MonitoringApp {

  //Subject 인터페이스: 옵저버 등록, 해제, 알림
  public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
  }

  //Observer 인터페이스: 업데이트 메서드
  public interface Observer {
    void update(String itemName, int count);
  }

  //재고 관리(Subject 구현체)
  public static class Inventory implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private final String itemName;
    private int count;
    private final int threshold;

    public Inventory(String itemName, int threshold) {
      this.itemName = itemName;
      this.threshold = threshold;
    }

    //재고 수량 설정. threshold 이하이면 알림 전송
    public void setCount(int count) {
      this.count = count;
      System.out.printf("[Inventory] '%s' 재고가 %d개로 변경되었습니다.%n", itemName, count);
      if (count <= threshold) {
        notifyObservers();
      }
    }

    @Override
    public void registerObserver(Observer o) {
      observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
      observers.remove(o);
    }

    @Override
    public void notifyObservers() {
      for (Observer o : observers) {
        o.update(itemName, count);
      }
    }
  }

  //재고 수량 설정. threshold 이하이면 알림 전송
  public static class CustomerNotifier implements Observer {
    @Override
    public void update(String itemName, int count) {
      System.out.printf("[CustomerNotifier] 고객님, 인기 상품 '%s' 재고가 %d개로 곧 품절됩니다!%n",
                        itemName, count);
    }
  }

  //물류팀 알림 (Observer 구현체)
  public static class LogisticsNotifier implements Observer {
    @Override
    public void update(String itemName, int count) {
      System.out.printf("[LogisticsNotifier] 물류팀: 상품 '%s' 재고가 %d개입니다. 보충을 준비하세요.%n",
                        itemName, count);
    }
  }

  public static void main(String[] args) {
    Inventory inventory = new Inventory("인기상품", 5);

    //옵저버 등록
    inventory.registerObserver(new CustomerNotifier());
    inventory.registerObserver(new LogisticsNotifier());

    //재고 수량 변경
    inventory.setCount(10);
    inventory.setCount(6);
    inventory.setCount(5); //threshold 도달 → 알림 전송
    inventory.setCount(2); //threshold 이하 → 계속 알림 전송
  }
}
