package ch07.facade;

public class Delivery {
    DeliveryInfo deliveryInfo;
    String requestMessage;

    public Delivery(DeliveryInfo deliveryInfo, String requestMessage) {
        this.deliveryInfo = deliveryInfo;
        this.requestMessage = requestMessage;
    }

    public void prepare() {
        System.out.println("배송 준비");
    }

    @Override
    public String toString() {
        return "배송지 : " + deliveryInfo + "\n요청 사항 : " + requestMessage;
    }
}
