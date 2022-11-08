package com.Adam.bankingapplication.DAO;

import com.Adam.bankingapplication.DTO.CustomerDTO;
import com.Adam.bankingapplication.Entities.Customer;
import com.Adam.bankingapplication.Exceptions.ResourceNotFoundException;
import com.Adam.bankingapplication.Validation.Validator;
import com.Adam.bankingapplication.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.sql.Date;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDAO {
	final
	CustomerRepository customerRepository;

	final
	PasswordEncoder passwordEncoder;

	public CustomerDAO (CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
		this.customerRepository = customerRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Customer saveNewCustomer(CustomerDTO customer) throws ResourceNotFoundException {
		Customer toSave = null;
		try {
			if (!customer.equals(null) && Validator.isEmailValid(customer.getEmail())) {
				if(Validator.isPasswordValid(String.valueOf(customer.getPassword()))) {
					customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
					System.out.println("testing customer after validation attempt: " + customer);
					toSave = new Customer(customer.getEmail(),
							passwordEncoder.encode(customer.getPassword()),
							customer.getRole() == null ? "user" : customer.getRole(),
							customer.getMobileNumber(),
							customer.getName(),
							Date.valueOf(customer.getCreateDt()));
					customerRepository.save(toSave);
				}
			}
		} catch (RuntimeException e) {
			throw new ResourceNotFoundException("Invalid credentials: " + e.getMessage());
		}
		return toSave;
	}

	public List<Customer> getCustomerByEmail(String email)  {
		if(email != null && Validator.isEmailValid(email)) {
			List<Customer> byEmail = customerRepository.findByEmail(email);
			return byEmail;
		}
		return new ArrayList<>();
	}

	public Customer getLoggedInCustomer(Authentication authentication) {
		List<Customer> customers = null;
		if(authentication != null) {
			customers = customerRepository.findByEmail(authentication.getName());
			return customers.get(0);
		}
		return null;
	}

}
