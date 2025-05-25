package ch03.decorator;

public abstract class Decorator implements RequestHandler {
    protected RequestHandler handler;
    
    public Decorator(RequestHandler handler) {
        this.handler = handler;
    }
    
    @Override
    public String handle(Request request) {
        return handler.handle(request);
    }
}

