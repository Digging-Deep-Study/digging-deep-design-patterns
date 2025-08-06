package ch10.state;

import ch10.TcpClient;

public class TimeWait implements State {
    private final TcpClient client;

    public TimeWait(TcpClient client) {
        this.client = client;
    }

    @Override
    public void open() {
        System.out.println("TIME_WAIT 상태입니다.");
    }

    @Override
    public void close() {
        System.out.println("TCP client : CLOSED");
        client.setState(client.getClosed());
    }

    @Override
    public void sendData(String data) {
        System.out.println("TIME_WAIT 상태입니다.");
    }
}
