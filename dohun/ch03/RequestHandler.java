package ch03;

import ch03.request.Request;

import javax.security.sasl.AuthenticationException;

public interface RequestHandler {
    void handle(Request request) throws AuthenticationException;
}
