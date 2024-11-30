package com.mon0mon.makingcleanarchitecture.application.port.in;

import com.mon0mon.makingcleanarchitecture.application.domain.model.Account;
import com.mon0mon.makingcleanarchitecture.application.domain.model.Money;

import static com.mon0mon.makingcleanarchitecture.application.domain.model.Account.*;

public interface GetAccountBalanceUsecase {
    Money getAccountBalance(GetAccountBalanceQuery query);

    record GetAccountBalanceQuery(AccountId accountId) {
    }
}
