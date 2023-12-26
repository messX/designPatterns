package org.example.facade;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Morgage {
    private Credit credit;
    private Loan loan;
    public static final int CREDIT_SCORE_LIMIT = 90;

    public boolean isEligibleForLoan(Customer customer, Long amount){
        if(credit.getCreditScore(customer) < CREDIT_SCORE_LIMIT){
            return false;
        }
        else if(loan.hasNoBadLoans(customer)){
            return false;
        }
        else if(Account.accountData.get(customer.getId()) - amount < 0){
            return false;
        }
        else {
            return true;
        }
    }
}
