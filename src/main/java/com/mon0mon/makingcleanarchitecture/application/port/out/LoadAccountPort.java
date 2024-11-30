package com.mon0mon.makingcleanarchitecture.application.port.out;

import com.mon0mon.makingcleanarchitecture.application.domain.model.Account;

import java.time.LocalDateTime;

import static com.mon0mon.makingcleanarchitecture.application.domain.model.Account.*;

public interface LoadAccountPort {
    Account loadAccount(AccountId accountId, LocalDateTime baselineDate);
}
