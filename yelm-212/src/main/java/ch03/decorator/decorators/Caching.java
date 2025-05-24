package ch03.decorator.decorators;

import ch03.decorator.Decorator;
import ch03.decorator.Request;
import ch03.decorator.RequestHandler;

import java.util.HashMap;
import java.util.Map;

public class Caching extends Decorator {
    private Map<String, String> cache = new HashMap<>();

    public Caching(RequestHandler handler) {
        super(handler);
    }

    @Override
    public String handle(Request request) {
        String url = request.getUrl();
        if (cache.containsKey(url)) {
            System.out.println("캐싱: " + url + " 요청에 대한 캐시 데이터 반환");
            return cache.get(url);
        }

        String result = handler.handle(request);
        cache.put(url, result);
        System.out.println("캐싱: " + url + " 요청 결과를 캐시에 저장");
        return result;
    }

    @Override
    public String getHandlerType() {
        return "Caching Handler";
    }
}
