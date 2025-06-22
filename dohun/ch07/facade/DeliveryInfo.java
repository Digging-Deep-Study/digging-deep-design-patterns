package ch07.facade;

public class DeliveryInfo {
    String name;
    String address;
    String phoneNumber;

    public DeliveryInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "받는사람 : " + name + ", 주소 : " + address + ", 전화번호 : " + phoneNumber;
    }
}
