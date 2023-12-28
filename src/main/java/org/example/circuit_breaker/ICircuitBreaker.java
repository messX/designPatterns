package org.example.circuit_breaker;

public interface ICircuitBreaker {
    void handleSuccess();
    void handleFailure(Object response);
    void reset();
    void setState(State state);
    State getState();
    Object attemptRequest() throws RemoteServiceException;
    void evaluateStateAfterFailure(Object response);
}
