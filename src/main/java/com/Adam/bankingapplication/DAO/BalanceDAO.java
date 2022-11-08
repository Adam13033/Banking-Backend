package com.Adam.bankingapplication.DAO;

import com.Adam.bankingapplication.Entities.AccountTransaction;
import com.Adam.bankingapplication.repositories.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class BalanceDAO {

	@Autowired
	AccountTransactionsRepository accountTransactionsRepository;

	public List<AccountTransaction> getBalanceDetails(@RequestParam int id) {
		if(id > 0) {
			List<AccountTransaction> transactions = accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
			return transactions;
		}
		return null;
	}
}
