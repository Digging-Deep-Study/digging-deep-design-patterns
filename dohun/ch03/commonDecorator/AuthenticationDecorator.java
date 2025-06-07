package ch03.commonDecorator;

import ch03.CommonDecorator;
import ch03.RequestHandler;
import ch03.request.Request;

import javax.security.sasl.AuthenticationException;

public class AuthenticationDecorator extends CommonDecorator {
    public AuthenticationDecorator(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handle(Request request) throws AuthenticationException {
        requestHandler.handle(request);

        logging();
        if (request.getId() != null && !request.getId().equalsIgnoreCase("dohun")) throw new AuthenticationException();
        System.out.println("success authentication");
    }

    @Override
    public void logging() {
        System.out.println("AuthenticationDecorator.handle");
    }
}
