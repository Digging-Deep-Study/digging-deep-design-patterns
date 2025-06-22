package ch07.facade;

import ch07.facade.payment.NaverPay;
import ch07.facade.payment.Payment;

public class Musinsa {
    public static void main(String[] args) {

        String orderer = "김도훈";
        String address = "인천 부평구 후정동로";
        String phoneNumber = "010-1234-5678";
        String requestMessage = "문 앞에 놔주세요";

        Payment payment = new NaverPay();
        DeliveryInfo deliveryInfo = new DeliveryInfo(orderer, address, phoneNumber);
        Delivery delivery = new Delivery(deliveryInfo, requestMessage);

        // 주문 생성
        Order order = new Order.Builder()
                .orderer(orderer)
                .payment(payment)
                .delivery(delivery)
                .build();

        // 주문
        order.order();

        System.out.println("---------------------------------");
        System.out.println("[주문 정보]");

        // 주문 확인
        System.out.println(order.getOrderInfo());

        System.out.println("---------------------------------");

        // 주문 상태 추적
        System.out.println(order.getStatus());

    }
}
