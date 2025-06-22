package ch07.facade;

import ch07.facade.payment.Payment;

public class Order {
    private OrderInfo orderInfo;
    private OrderStatus orderStatus;
    private Inventory inventory;
    private Payment payment;
    private Delivery delivery;

    public static class Builder {
        private OrderInfo orderInfo;
        private OrderStatus orderStatus = OrderStatus.ORDER_CONFIRM;
        private Inventory inventory = new Inventory();
        private Payment payment;
        private Delivery delivery;

        public Builder orderer(String orderer) {
            this.orderInfo = new OrderInfo(orderer);
            return this;
        }

        public Builder payment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Builder delivery(Delivery delivery) {
            this.delivery = delivery;
            return this;
        }

        public Order build() {
            return new Order(orderInfo, orderStatus, inventory, payment, delivery);
        }

    }
    private Order(OrderInfo orderInfo, OrderStatus orderStatus, Inventory inventory, Payment payment, Delivery delivery) {
        this.orderInfo = orderInfo;
        this.orderStatus = orderStatus;
        this.inventory = inventory;
        this.payment = payment;
        this.delivery = delivery;
    }

    // 주문
    public void order() {
        if (!inventory.isOnStock(1)) throw new IllegalStateException("재고가 부족합니다.");

        payment.pay();
        orderStatus = OrderStatus.ORDER_COMPLETED;
        delivery.prepare();
    }

    // 주문 확인
    public String getOrderInfo() {
        return orderInfo + "\n" +
                orderStatus + "\n" +
                payment + "\n" +
                delivery;
    }

    // 주문 상태 추적
    public String getStatus() {
        return orderStatus.getValue();
    }

}
