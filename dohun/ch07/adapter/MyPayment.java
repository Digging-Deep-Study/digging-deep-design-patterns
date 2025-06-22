package ch07.adapter;

public class MyPayment implements Payment {
    PaymentStatus status = PaymentStatus.NONE;

    @Override
    public void pay() {
        System.out.println("MyPayment pay");
        status = PaymentStatus.SUCCESS;
    }

    @Override
    public void refund() {
        System.out.println("MyPayment refund");
        status = PaymentStatus.REFUND;
    }

    @Override
    public void getStatus() {
        System.out.println("MyPayment status : " + status);
    }
}
