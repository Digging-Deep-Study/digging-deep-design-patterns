package ch10.state;

import ch10.TcpClient;

public class Established implements State {
    private final TcpClient client;

    public Established(TcpClient client) {
        this.client = client;
    }

    @Override
    public void open() {
        System.out.println("이미 ESTABLISHED 상태입니다.");
    }

    @Override
    public void close() {
        System.out.println("TCP client : FIN_WAIT");
        client.setState(client.getFinWait());
    }

    @Override
    public void sendData(String data) {
        System.out.println("이미 ESTABLISHED 상태입니다.");
    }
}
