package org.example.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args){
        Customer customer = new Customer(1L, "Manu");
        Morgage morgage = new Morgage(new Credit(), new Loan());
        if(morgage.isEligibleForLoan(customer, 1000L)){
            log.info(String.format("Customer %s is eligible for loan", customer));
        }
        else{
            log.info(String.format("Customer %s is not eligible for loan", customer));
        }
    }
}
