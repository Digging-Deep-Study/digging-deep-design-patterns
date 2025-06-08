package ch03.commonDecorator;

import ch03.CommonDecorator;
import ch03.RequestHandler;
import ch03.request.Request;

import javax.security.sasl.AuthenticationException;

public class LoggingDecorator extends CommonDecorator {
    public LoggingDecorator(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handle(Request request) throws AuthenticationException {
        requestHandler.handle(request);

        logging();
        System.out.println("[" + request.getMethod() + "] " + request.getUrl() + " : " + request.getData());
    }

    @Override
    public void logging() {
        System.out.println("LoggingDecorator.handle");
    }
}
