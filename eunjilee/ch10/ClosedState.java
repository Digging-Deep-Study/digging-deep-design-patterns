package ch10;

public final class ClosedState implements TcpState {
  public static final ClosedState INSTANCE = new ClosedState();

  private ClosedState() {
  }


  @Override
  public void open(final TcpConnection connection) {
    System.out.println("[CLOSED] open() -> LISTENING");
    connection.setState(ListeningState.INSTANCE);
  }

  @Override
  public void close(final TcpConnection connection) {
    System.out.println("[CLOSED] close() -> 이미 닫힌 상태입니다.");
  }

  @Override
  public void synReceived(final TcpConnection connection) {
    System.out.println("[CLOSED] synReceived() → 동작 없음");
  }

  @Override
  public void finReceived(final TcpConnection connection) {
    System.out.println("[CLOSED] finReceived() → 동작 없음");
  }

  @Override
  public String toString() {
    return "CLOSED";
  }
}
