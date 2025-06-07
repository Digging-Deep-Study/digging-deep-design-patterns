package ch03;

public abstract class CommonDecorator implements RequestHandler {
    protected RequestHandler requestHandler;

    public CommonDecorator(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public abstract void logging();
}
