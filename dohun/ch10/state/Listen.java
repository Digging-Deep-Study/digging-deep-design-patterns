package ch10.state;

import ch10.TcpClient;

public class Listen implements State {
    private final TcpClient client;

    public Listen(TcpClient client) {
        this.client = client;
    }

    @Override
    public void open() {
        System.out.println("OPEN 후 LISTEN 상태입니다.");
    }

    @Override
    public void close() {
        System.out.println("OPEN 후 LISTEN 상태입니다.");
    }

    @Override
    public void sendData(String data) {
        System.out.println("SYN_SENT : " + data);
        System.out.println("TCP client : SYN_SENT");
        client.setState(client.getSynSent());
    }
}
