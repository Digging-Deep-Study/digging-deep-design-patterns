package ch03.decorator.decorators;

import ch03.decorator.Decorator;
import ch03.decorator.Request;
import ch03.decorator.RequestHandler;

public class Authentication extends Decorator {
    public Authentication(RequestHandler handler) {
        super(handler);
    }

    @Override
    public String handle(Request request) {
        System.out.println("인증: " + request.getUrl() + " 요청에 대한 사용자 인증 수행");
        // 인증 로직을 여기에 구현
        return handler.handle(request);
    }

    @Override
    public String getHandlerType() {
        return "Authentication Handler";
    }
}
