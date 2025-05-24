package ch03.decorator.decorators;

import ch03.decorator.Decorator;
import ch03.decorator.Request;
import ch03.decorator.RequestHandler;


public class Compression extends Decorator {
    public Compression(RequestHandler handler) {
        super(handler);
    }

    @Override
    public String handle(Request request) {
        System.out.println("압축: " + request.getUrl() + " 요청 데이터 압축");
        String result = handler.handle(request);
        System.out.println("압축: " + request.getUrl() + " 응답 데이터 압축");
        return result + " (압축됨)";
    }

    @Override
    public String getHandlerType() {
        return "Compression Handler";
    }
}