package ch03.decorator;

public interface RequestHandler {
    String handle(Request request);
    String getHandlerType();
} 