package com.mon0mon.makingcleanarchitecture.adapter.in.web;

import com.mon0mon.makingcleanarchitecture.application.domain.model.Money;
import com.mon0mon.makingcleanarchitecture.application.port.in.SendMoneyCommand;
import com.mon0mon.makingcleanarchitecture.application.port.in.SendMoneyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mon0mon.makingcleanarchitecture.application.domain.model.Account.*;

@RestController
@RequiredArgsConstructor
public class SendMoneyController {
    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping(path = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    void sendMoney(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") Long amount) {

        SendMoneyCommand command = new SendMoneyCommand(
                new AccountId(sourceAccountId),
                new AccountId(targetAccountId),
                Money.of(amount));

        sendMoneyUseCase.sendMoney(command);
    }

}
