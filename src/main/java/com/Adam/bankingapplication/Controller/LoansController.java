package com.Adam.bankingapplication.Controller;

import com.Adam.bankingapplication.DAO.LoanDAO;
import com.Adam.bankingapplication.Entities.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

	@Autowired
	LoanDAO loanDAO;

	@GetMapping("/myLoans")
	public List<Loan> getLoanDetails(@RequestParam int id) {
		return loanDAO.getLoansById(id);
	}
}
