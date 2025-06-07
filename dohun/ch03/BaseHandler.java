package ch03;

import ch03.request.Request;

import javax.security.sasl.AuthenticationException;

public class BaseHandler implements RequestHandler {

    @Override
    public void handle(Request request) throws AuthenticationException {
        System.out.println("BaseHandler request handled");
    }
}
