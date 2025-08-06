package ch10.state;

import ch10.TcpClient;

public class SynSent implements State {
    private final TcpClient client;

    public SynSent(TcpClient client) {
        this.client = client;
    }

    @Override
    public void open() {
        System.out.println("TCP client : ESTABLISHED");
        client.setState(client.getEstablished());
    }

    @Override
    public void close() {
        System.out.println("SYN_SENT 상태입니다.");
    }

    @Override
    public void sendData(String data) {
        System.out.println("SYN_SENT 상태입니다.");
    }
}
