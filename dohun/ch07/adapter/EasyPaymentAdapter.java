package ch07.adapter;

public class EasyPaymentAdapter implements Payment {
    EasyPayment easyPayment;

    public EasyPaymentAdapter(EasyPayment easyPayment) {
        this.easyPayment = easyPayment;
    }

    @Override
    public void pay() {
        easyPayment.pay();
    }

    @Override
    public void refund() {
        easyPayment.refund();
    }

    @Override
    public void getStatus() {
        easyPayment.getStatus();
    }
}
