package ch03.decorator;

public class BaseHandler implements RequestHandler {
    @Override
    public String handle(Request request) {
        // 실제 비즈니스 로직을 처리하는 핸들러
        return "처리된 요청: " + request.getUrl();
    }

    @Override
    public String getHandlerType() {
        return "Base Handler";
    }
} 