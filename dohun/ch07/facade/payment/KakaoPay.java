package ch07.facade.payment;

public class KakaoPay implements Payment {
    @Override
    public void pay() {
        System.out.println("카카오페이 결제");
    }

    @Override
    public String toString() {
        return "결제수단 : 카카오페이";
    }
}
