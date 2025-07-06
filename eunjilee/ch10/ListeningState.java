package ch10;

public final class ListeningState implements TcpState {
  public static final ListeningState INSTANCE = new ListeningState();

  private ListeningState() {
  }

  @Override
  public void open(final TcpConnection connection) {
    System.out.println("[LISTENING] open() → 이미 수신 대기 중입니다.");
  }

  @Override
  public void close(final TcpConnection connection) {
    System.out.println("[LISTENING] close() → CLOSED");
    connection.setState(ClosedState.INSTANCE);
  }

  @Override
  public void synReceived(final TcpConnection connection) {
    System.out.println("[LISTENING] synReceived() → ESTABLISHED");
    connection.setState(EstablishedState.INSTANCE);
  }

  @Override
  public void finReceived(final TcpConnection connection) {
    System.out.println("[LISTENING] finReceived() → 동작 없음");
  }

  @Override
  public String toString() {
    return "LISTENING";
  }
}

