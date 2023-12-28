package org.example.circuit_breaker;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import java.util.Random;

@Slf4j
@AllArgsConstructor
public class DelayedRemoteService implements IRemoteService{

    private final Random random;
    private int randVal;

    DelayedRemoteService(){
        this.random = new Random();
    }

    private void resetRandom() {
        log.info("Resetting random");
        randVal = random.nextInt();
    }

    /**
     * Responds based on randome value, odd and even if the service is down / working.
     *
     * @return The state of the service
     */
    @Override
    public String call() throws RemoteServiceException {
        // service ranmondly works
        resetRandom();
        if (randVal % 5 == 0) {
            //Can use Thread.sleep() here to block and simulate a hung server
            return "Delayed service is working";

        }
        throw new RemoteServiceException("Delayed service is down");
    }
}
