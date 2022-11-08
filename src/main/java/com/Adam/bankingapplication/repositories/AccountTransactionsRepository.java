package com.Adam.bankingapplication.repositories;

import com.Adam.bankingapplication.Entities.AccountTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransaction, Long> {

	List<AccountTransaction> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
