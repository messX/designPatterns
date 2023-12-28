package org.example.circuit_breaker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultCircuitBreaker implements ICircuitBreaker{
    private final int halfOpenLimit;
    private final int failureLimitToOpen;
    private final int openTimeout;
    private long lastSuccessTime;
    private int currentFailureCount;
    private State currentState;
    IRemoteService remoteService;

    DefaultCircuitBreaker(IRemoteService service, int halfOpenLimit, int openTimeout, int failureLimitToOpen){
        this.currentFailureCount = 0;
        this.currentState = State.CLOSED;
        this.lastSuccessTime = System.currentTimeMillis();
        this.remoteService = service;
        this.halfOpenLimit = halfOpenLimit;
        this.failureLimitToOpen = failureLimitToOpen;
        this.openTimeout = openTimeout;
    }

    @Override
    public void handleSuccess() {
        reset();
    }

    @Override
    public void handleFailure(Object response) {
        this.currentFailureCount++;
        evaluateStateAfterFailure(response);
    }

    public void reset(){
        log.info("Resetting the circuit to default state");
        this.currentFailureCount = 0;
        this.currentState = State.CLOSED;
        this.lastSuccessTime = System.currentTimeMillis();
    }

    @Override
    public void setState(State state) {
        log.info(String.format("Setting state to %s", state.toString()));
        this.currentState = state;
    }

    @Override
    public State getState() {
        return this.currentState;
    }

    @Override
    public Object attemptRequest() throws RemoteServiceException {
        Object response;
        if(this.currentState == State.OPEN){
            log.info("in open state cant fetch the response");
            response = new RemoteServiceException("Error in response");
            this.handleFailure(response);
            return response;
        }
        try{
            response = remoteService.call();
            log.info("Respnse recived succesfully");
            this.handleSuccess();
        }
        catch (RemoteServiceException ex){
            log.info("Error in response");
            this.handleFailure(ex);
            throw ex;
        }
        return response;
    }

    @Override
    public void evaluateStateAfterFailure(Object response) {
        long timeSinceLastSuccess = System.currentTimeMillis() - this.lastSuccessTime;
        // open state and time elapsed is more than open timeout try setting to halfopen
        if(currentState == State.OPEN && timeSinceLastSuccess > openTimeout){
            setState(State.HALF_OPEN);
        }
        else if(currentState == State.HALF_OPEN && (currentFailureCount % failureLimitToOpen >= halfOpenLimit)){
            setState(State.OPEN);
        }
        else if(currentState == State.CLOSED  && currentFailureCount > failureLimitToOpen){
            setState(State.OPEN);
        }
    }


}
