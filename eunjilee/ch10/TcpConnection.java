package ch10;

public class TcpConnection {
  private TcpState state = ClosedState.INSTANCE;

  void setState(TcpState state) {
    this.state = state;
    System.out.println(">>> 상태 변경: " + state);
  }

  public void open() {
    state.open(this);
  }

  public void close() {
    state.close(this);
  }

  public void synReceived() {
    state.synReceived(this);
  }

  public void finReceived() {
    state.finReceived(this);
  }

  public TcpState getState() {
    return state;
  }
}
