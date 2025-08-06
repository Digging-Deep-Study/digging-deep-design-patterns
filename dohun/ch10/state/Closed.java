package ch10.state;

import ch10.TcpClient;

public class Closed implements State {
    private final TcpClient client;

    public Closed(final TcpClient client) {
        this.client = client;
    }

    @Override
    public void open() {
        System.out.println("TCP client : LISTEN");
        client.setState(client.getListen());
    }

    @Override
    public void close() {
        System.out.println("CLOSED 상태입니다.");
    }

    @Override
    public void sendData(String data) {
        System.out.println("CLOSED 상태입니다.");
    }
}
