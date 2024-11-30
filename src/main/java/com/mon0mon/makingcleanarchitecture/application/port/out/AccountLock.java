package com.mon0mon.makingcleanarchitecture.application.port.out;

import com.mon0mon.makingcleanarchitecture.application.domain.model.Account;

public interface AccountLock {
    void lockAccount(Account.AccountId accountId);

    void releaseAccount(Account.AccountId accountId);
}
