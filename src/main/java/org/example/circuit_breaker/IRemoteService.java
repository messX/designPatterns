package org.example.circuit_breaker;

public interface IRemoteService {
    Object call() throws RemoteServiceException;
}
