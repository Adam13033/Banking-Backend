package com.Adam.bankingapplication.Controller;

import com.Adam.bankingapplication.DAO.BalanceDAO;
import com.Adam.bankingapplication.Entities.AccountTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

	@Autowired
	BalanceDAO balanceDAO;

	@GetMapping("/myBalance")
	public List<AccountTransaction> getBalanceDetails(@RequestParam int id) {
		return  balanceDAO.getBalanceDetails(id);
	}

}
