package com.mon0mon.makingcleanarchitecture.application.domain.service;

import com.mon0mon.makingcleanarchitecture.application.port.in.SendMoneyCommand;
import com.mon0mon.makingcleanarchitecture.application.port.in.SendMoneyUseCase;
import com.mon0mon.makingcleanarchitecture.application.port.out.AccountLock;
import com.mon0mon.makingcleanarchitecture.application.port.out.LoadAccountPort;
import com.mon0mon.makingcleanarchitecture.application.port.out.UpdateAccountStatePort;
import com.mon0mon.makingcleanarchitecture.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class SendMoneyService implements SendMoneyUseCase {
    private final LoadAccountPort loadAccountPort;
    private final AccountLock accountLock;
    private final UpdateAccountStatePort accountStatePort;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        //  TODO: 비즈니스 규칙 검증
        //  TODO: 모델 상태 조작
        //  TODO: 출력 값 반환
        return false;
    }
}
