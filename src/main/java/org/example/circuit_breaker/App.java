package org.example.circuit_breaker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
      log.info("Testing the circuit breaker");
      DefaultCircuitBreaker remoteServiceWithCircuitBreaker = new DefaultCircuitBreaker(new DelayedRemoteService(), 2,
              60 * 1000, 3);
      log.info("Get date from remote");
      Object res;
      int i = 15;
      while (i >0){
          try{
              res = remoteServiceWithCircuitBreaker.attemptRequest();
              log.info(String.format("Response from remote %s", res.toString()));
              log.info(String.format("Current state %s", remoteServiceWithCircuitBreaker.getState().toString()));
          }
          catch (RemoteServiceException ex){
              log.error(String.format("Unable to get data from remote res: %s", ex.getMessage()));
              log.info(String.format("Current state %s", remoteServiceWithCircuitBreaker.getState().toString()));
          }
        i--;
      }


    }
}
