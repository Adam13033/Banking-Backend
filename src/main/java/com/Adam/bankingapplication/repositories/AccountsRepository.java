package com.Adam.bankingapplication.repositories;

import com.Adam.bankingapplication.Entities.Account;
import com.Adam.bankingapplication.Entities.AccountTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<AccountTransaction, Long> {

	Account findByCustomerId(int customerId);

}
