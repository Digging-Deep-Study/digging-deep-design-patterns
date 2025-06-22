package ch07.adapter;

public class Main {
    public static void main(String[] args) {

        // 기존 결제
        Payment myPayment = new MyPayment();
        myPayment.pay();
        myPayment.refund();
        myPayment.getStatus();

        // 간편 결제
        EasyPaymentAdapter adapter = new EasyPaymentAdapter(new EasyPayment());
        adapter.pay();
        adapter.refund();
        adapter.getStatus();

    }
}
