package com.mon0mon.makingcleanarchitecture.application.domain.service;

import com.mon0mon.makingcleanarchitecture.application.domain.model.Money;
import com.mon0mon.makingcleanarchitecture.application.port.in.GetAccountBalanceUsecase;
import com.mon0mon.makingcleanarchitecture.application.port.out.LoadAccountPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import static com.mon0mon.makingcleanarchitecture.application.port.in.GetAccountBalanceUsecase.*;

@RequiredArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceUsecase {
    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(GetAccountBalanceQuery query) {
        return loadAccountPort.loadAccount(query.accountId(), LocalDateTime.now())
                              .calculateBalance();
    }
}
