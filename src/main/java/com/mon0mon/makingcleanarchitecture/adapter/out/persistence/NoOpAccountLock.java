package com.mon0mon.makingcleanarchitecture.adapter.out.persistence;

import com.mon0mon.makingcleanarchitecture.application.port.out.AccountLock;
import org.springframework.stereotype.Component;

import static com.mon0mon.makingcleanarchitecture.application.domain.model.Account.*;

@Component
class NoOpAccountLock implements AccountLock {

    @Override
    public void lockAccount(AccountId accountId) {
        // do nothing
    }

    @Override
    public void releaseAccount(AccountId accountId) {
        // do nothing
    }

}
