package ch10;

public final class FinWaitState implements TcpState {
  public static final FinWaitState INSTANCE = new FinWaitState();

  private FinWaitState() {
  }

  @Override
  public void open(final TcpConnection connection) {
    System.out.println("[FIN-WAIT] open() → 동작 없음");
  }

  @Override
  public void close(final TcpConnection connection) {
    System.out.println("[FIN-WAIT] close() → 이미 FIN-WAIT 상태입니다.");
  }

  @Override
  public void synReceived(final TcpConnection connection) {
    System.out.println("[FIN-WAIT] synReceived() → 동작 없음");
  }

  @Override
  public void finReceived(final TcpConnection connection) {
    System.out.println("[FIN-WAIT] finReceived() → CLOSED");
    connection.setState(ClosedState.INSTANCE);
  }

  @Override
  public String toString() {
    return "FIN-WAIT";
  }
}
