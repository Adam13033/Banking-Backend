package com.Adam.bankingapplication.DAO;

import com.Adam.bankingapplication.Entities.Loan;
import com.Adam.bankingapplication.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoanDAO {

	@Autowired
	LoanRepository loanRepository;

	public List<Loan> getLoansById(int id) {
		List<Loan> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
		return loans;
	}

}
