package ch07.adapter;

public class EasyPayment {
    PaymentStatus status = PaymentStatus.NONE;

    public void pay() {
        System.out.println("EasyPayment pay");
        status = PaymentStatus.SUCCESS;
    }

    public void refund() {
        System.out.println("EasyPayment refund");
        status = PaymentStatus.REFUND;
    }

    public void getStatus() {
        throw new UnsupportedOperationException();
    }

}
