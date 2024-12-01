package com.mon0mon.makingcleanarchitecture.application.port.in;

import com.mon0mon.makingcleanarchitecture.application.domain.model.Account.AccountId;
import com.mon0mon.makingcleanarchitecture.application.domain.model.Money;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class SendMoneyCommandTest {

    @Test
    public void validationOk() {
        new SendMoneyCommand(
                new AccountId(42L),
                new AccountId(43L),
                new Money(new BigInteger("10")));
        // no exception
    }

    @Test
    public void moneyValidationFails() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            new SendMoneyCommand(
                    new AccountId(42L),
                    new AccountId(43L),
                    new Money(new BigInteger("-10")));
        });
    }

    @Test
    public void accountIdValidationFails() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            new SendMoneyCommand(
                    new AccountId(42L),
                    null,
                    new Money(new BigInteger("10")));
        });
    }

}
