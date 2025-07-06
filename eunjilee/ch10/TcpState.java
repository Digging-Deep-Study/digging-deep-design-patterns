package ch10;

public sealed interface TcpState permits ClosedState, ListeningState, EstablishedState, FinWaitState {

  void open(TcpConnection connection);

  void close(TcpConnection connection);

  void synReceived(TcpConnection connection);

  void finReceived(TcpConnection connection);
}
