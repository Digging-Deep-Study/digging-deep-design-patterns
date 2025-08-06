package ch12.state;

import ch12.IoTApp;

public abstract class State {
    protected final IoTApp app;
    protected String name;

    public State(IoTApp app, String name) {
        this.app = app;
        this.name = name;
    }

    public void update(int temp) {
        if (temp <= 18) app.setState(app.getSoCool());
        else if (temp <= 25) app.setState(app.getCool());
        else if (temp <= 29) app.setState(app.getHot());
        else app.setState(app.getSoHot());
    }

    public String getName() {
        return name;
    }
}
