package com.mon0mon.makingcleanarchitecture.application.port.in;

public interface SendMoneyUseCase {
    public boolean sendMoney(SendMoneyCommand command);
}
