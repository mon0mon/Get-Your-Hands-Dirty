package com.mon0mon.makingcleanarchitecture.adapter.out.persistence;

import com.mon0mon.makingcleanarchitecture.application.domain.model.Account;
import com.mon0mon.makingcleanarchitecture.application.domain.model.Activity;
import com.mon0mon.makingcleanarchitecture.application.port.out.LoadAccountPort;
import com.mon0mon.makingcleanarchitecture.application.port.out.UpdateAccountStatePort;
import com.mon0mon.makingcleanarchitecture.common.PersistenceAdapter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

import static com.mon0mon.makingcleanarchitecture.application.domain.model.Account.*;

@RequiredArgsConstructor
@PersistenceAdapter
class AccountPersistenceAdapter implements
        LoadAccountPort,
        UpdateAccountStatePort {

    private final SpringDataAccountRepository accountRepository;
    private final ActivityRepository activityRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account loadAccount(
            AccountId accountId,
            LocalDateTime baselineDate) {

        AccountJpaEntity account =
                accountRepository.findById(accountId.getValue())
                                 .orElseThrow(EntityNotFoundException::new);

        List<ActivityJpaEntity> activities =
                activityRepository.findByOwnerSince(
                        accountId.getValue(),
                        baselineDate);

        Long withdrawalBalance = activityRepository
                .getWithdrawalBalanceUntil(
                        accountId.getValue(),
                        baselineDate)
                .orElse(0L);

        Long depositBalance = activityRepository
                .getDepositBalanceUntil(
                        accountId.getValue(),
                        baselineDate)
                .orElse(0L);

        return accountMapper.mapToDomainEntity(
                account,
                activities,
                withdrawalBalance,
                depositBalance);

    }

    @Override
    public void updateActivities(Account account) {
        for (Activity activity : account.getActivityWindow()
                                        .getActivities()) {
            if (activity.getId() == null) {
                activityRepository.save(accountMapper.mapToJpaEntity(activity));
            }
        }
    }

}
