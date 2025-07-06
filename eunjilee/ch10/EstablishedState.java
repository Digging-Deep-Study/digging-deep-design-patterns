package ch10;

public final class EstablishedState implements TcpState {
  public static final EstablishedState INSTANCE = new EstablishedState();

  private EstablishedState() {
  }

  @Override
  public void open(final TcpConnection connection) {
    System.out.println("[ESTABLISHED] open() → 이미 연결이 수립되어 있습니다.");
  }

  @Override
  public void close(final TcpConnection connection) {
    System.out.println("[ESTABLISHED] close() → FIN-WAIT");
    connection.setState(FinWaitState.INSTANCE);
  }

  @Override
  public void synReceived(final TcpConnection connection) {
    System.out.println("[ESTABLISHED] synReceived() → 동작 없음");
  }

  @Override
  public void finReceived(final TcpConnection connection) {
    System.out.println("[ESTABLISHED] finReceived() → CLOSED");
    connection.setState(ClosedState.INSTANCE);
  }

  @Override
  public String toString() {
    return "ESTABLISHED";
  }
}
