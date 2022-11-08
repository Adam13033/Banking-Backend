package com.Adam.bankingapplication.Controller;

import com.Adam.bankingapplication.DAO.AccountDAO;
import com.Adam.bankingapplication.Entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@Autowired
	AccountDAO accountDAO;

	@GetMapping("/myAccount")
	public Account getAccountDetails(@RequestParam int id) {
		Account account = accountDAO.getAccountDetailsById(id);
		if(account != null) {
			return account;
		}
		return null;
	}
}
