package ch07.facade.payment;

public class NaverPay implements Payment {
    @Override
    public void pay() {
        System.out.println("네이버페이 결제");
    }

    @Override
    public String toString() {
        return "결제수단 : 네이버페이";
    }
}
