package ch03.decorator.decorators;

import ch03.decorator.Decorator;
import ch03.decorator.Request;
import ch03.decorator.RequestHandler;

public class Logging extends Decorator {
    public Logging(RequestHandler handler) {
        super(handler);
    }

    @Override
    public String handle(Request request) {
        System.out.println("로깅: " + request.getUrl() + " 요청 처리 시작");
        String result = handler.handle(request);
        System.out.println("로깅: " + request.getUrl() + " 요청 처리 완료");
        return result;
    }

    @Override
    public String getHandlerType() {
        return "Logging Handler";
    }
}
