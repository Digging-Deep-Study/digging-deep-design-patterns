package ch07.facade.payment;

public class TossPay implements Payment {
    @Override
    public void pay() {
        System.out.println("토스페이 결제");
    }

    @Override
    public String toString() {
        return "결제수단 : 토스페이";
    }
}
