package com.mon0mon.makingcleanarchitecture.application.port.out;

import com.mon0mon.makingcleanarchitecture.application.domain.model.Account;

public interface UpdateAccountStatePort {

    void updateActivities(Account account);

}
