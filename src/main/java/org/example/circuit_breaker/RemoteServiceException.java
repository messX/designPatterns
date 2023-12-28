package org.example.circuit_breaker;

public class RemoteServiceException extends Exception {
    public RemoteServiceException(String messge){
        super(messge);
    }
}
