package ch07.facade;

public class OrderInfo {
    private String orderer;

    public OrderInfo(String orderer) {
        this.orderer = orderer;
    }

    @Override
    public String toString() {
        return "주문자 : " + orderer;
    }
}
