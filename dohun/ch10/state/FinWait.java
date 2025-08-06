package ch10.state;

import ch10.TcpClient;

public class FinWait implements State {
    private final TcpClient client;

    public FinWait(TcpClient client) {
        this.client = client;
    }

    @Override
    public void open() {
        System.out.println("FIN_WAIT 상태입니다.");
    }

    @Override
    public void close() {
        System.out.println("TCP client : TIME_WAIT");
        client.setState(client.getTimeWait());
    }

    @Override
    public void sendData(String data) {

    }
}
