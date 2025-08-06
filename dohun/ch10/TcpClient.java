package ch10;

import ch10.state.*;

public class TcpClient {

    private final State closed;
    private final State listen;
    private final State synSent;
    private final State established;
    private final State finWait;
    private final State timeWait;

    State state;

    public TcpClient() {
        closed = new Closed(this);
        listen = new Listen(this);
        synSent = new SynSent(this);
        established = new Established(this);
        finWait = new FinWait(this);
        timeWait = new TimeWait(this);

        state = closed;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getClosed() {
        return closed;
    }

    public State getListen() {
        return listen;
    }

    public State getSynSent() {
        return synSent;
    }

    public State getEstablished() {
        return established;
    }

    public State getFinWait() {
        return finWait;
    }

    public State getTimeWait() {
        return timeWait;
    }

    public void open() {
        state.open();
    }

    public void close() {
        state.close();
    }

    public void sendData(String data) {
        state.sendData(data);
    }
}
