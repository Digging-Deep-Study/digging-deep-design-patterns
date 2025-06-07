package ch03.commonDecorator;

import ch03.CommonDecorator;
import ch03.RequestHandler;
import ch03.request.Request;
import ch03.request.RequestURL;

import javax.security.sasl.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

public class CachingDecorator extends CommonDecorator {
    static Map<RequestURL, String> cache = new HashMap<>();

    public CachingDecorator(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handle(Request request) throws AuthenticationException {
        requestHandler.handle(request);

        logging();
        cache.putIfAbsent(request.getUrl(), request.getData());
        System.out.println("caching " + request.getUrl());
    }

    @Override
    public void logging() {
        System.out.println("CachingDecorator.handle");
    }
}
