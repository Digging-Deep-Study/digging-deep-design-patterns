package ch10.state;

public interface State {
    void open();
    void close();
    void sendData(String data);
}
