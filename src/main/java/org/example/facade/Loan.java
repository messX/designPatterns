package org.example.facade;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Loan {

    public static List<Long> badLoans = Arrays.asList(1L, 2L);
    public boolean hasNoBadLoans(Customer customer){
        if (badLoans.contains(customer.getId())){
            log.error("Already has bad loan");
            return true;
        }
        else {
            return false;
        }
    }
}
