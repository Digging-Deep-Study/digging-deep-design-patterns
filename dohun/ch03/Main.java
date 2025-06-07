package ch03;

import ch03.commonDecorator.AuthenticationDecorator;
import ch03.commonDecorator.CachingDecorator;
import ch03.commonDecorator.LoggingDecorator;
import ch03.request.Request;
import ch03.request.RequestAddr;
import ch03.request.RequestMethod;
import ch03.request.RequestURL;

public class Main {

    public static void main(String[] args) {
        try {
            RequestURL url = new RequestURL("https://github.com/Digging-Deep-Study/digging-deep-design-patterns");
            String id = "dohun";
            String data = "{\"key\":\"study\"}";
            RequestMethod method = RequestMethod.GET;
            RequestAddr addr = new RequestAddr("127.0.0.1");

            Request request = new Request(url, id, data, method, addr);

            RequestHandler baseHandler = new BaseHandler();
            baseHandler.handle(request);
            System.out.println("--------------------------------------------------------------------------------------------------------------");

            RequestHandler authenticationHandler = new AuthenticationDecorator(baseHandler);
            authenticationHandler.handle(request);
            System.out.println("--------------------------------------------------------------------------------------------------------------");

            RequestHandler cachingHandler = new CachingDecorator(baseHandler);
            cachingHandler.handle(request);
            System.out.println("--------------------------------------------------------------------------------------------------------------");

            RequestHandler loggingHandler = new LoggingDecorator(baseHandler);
            loggingHandler.handle(request);
            System.out.println("--------------------------------------------------------------------------------------------------------------");

            RequestHandler requestHandlerA = new CachingDecorator(new AuthenticationDecorator(baseHandler));
            requestHandlerA.handle(request);
            System.out.println("--------------------------------------------------------------------------------------------------------------");

            RequestHandler requestHandlerB = new LoggingDecorator(new CachingDecorator(new AuthenticationDecorator(baseHandler)));
            requestHandlerB.handle(request);
            System.out.println("--------------------------------------------------------------------------------------------------------------");


        } catch (Exception ignored) {}
    }
}
