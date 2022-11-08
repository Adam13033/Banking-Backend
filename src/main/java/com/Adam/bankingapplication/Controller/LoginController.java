package com.Adam.bankingapplication.Controller;

import com.Adam.bankingapplication.DAO.CustomerDAO;
import com.Adam.bankingapplication.DTO.CustomerDTO;
import com.Adam.bankingapplication.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
	@Autowired
	CustomerDAO customerDAO;

	@Autowired
	PasswordEncoder passwordEncoder;


	@RequestMapping("/register")
	public ResponseEntity registerUser(@RequestBody CustomerDTO customer) {
		Customer savedCustomer = null;
		ResponseEntity response = null;
		System.out.println("Inside of register endpoint testing REACT: " + customer);
		try {
			savedCustomer = customerDAO.saveNewCustomer(customer);
			if(savedCustomer.getId() >= 0) {
				response = ResponseEntity
						.status(HttpStatus.CREATED)
						.body("User successfully created, you may now login!");
			}
		} catch(Exception e) {
			response = ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error has occurred relating to: " + e.getMessage());
		}
		return response;
	}

//	@RequestMapping("/user")
//	public Customer getUserDetailsFollowingLogin(Authentication authentication) {
//		return customerDAO.getLoggedInCustomer(authentication);
//	}
}
