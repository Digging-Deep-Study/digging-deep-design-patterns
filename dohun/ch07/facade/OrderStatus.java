package ch07.facade;

public enum OrderStatus {
    ORDER_CONFIRM("주문 확인"),
    ORDER_COMPLETED("주문 완료"),
    SHIPPING("출고중"),
    ON_DELIVERY("배송중"),
    DELIVERY_COMPLETED("배송 완료");

    String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "주문 상태 : " + value;
    }
}
