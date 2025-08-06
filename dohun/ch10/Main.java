package ch10;

public class Main {
    public static void main(String[] args) {
        TcpClient client = new TcpClient();

        client.open();
        client.sendData("TCP Connection Test");
        client.open();
        client.close();
        client.close();
        client.close();
    }
}
