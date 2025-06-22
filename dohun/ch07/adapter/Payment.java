package ch07.adapter;

public interface Payment {
    void pay();
    void refund();
    void getStatus();
}
