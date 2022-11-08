package com.Adam.bankingapplication.DAO;

import com.Adam.bankingapplication.Entities.Account;
import com.Adam.bankingapplication.repositories.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	@Autowired
	AccountsRepository accountsRepository;

	public Account getAccountDetailsById(int id) {
		if(id > 0) {
			Account account = accountsRepository.findByCustomerId(id);
		}
		return null;
	}


}
