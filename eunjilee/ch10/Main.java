package ch10;

public class Main {
  public static void main(String[] args) {
    TcpConnection connection = new TcpConnection();
    System.out.println("조기 상태: " + connection.getState());

    connection.open();
    connection.synReceived();
    connection.close();
    connection.finReceived();
  }
}
