package com.Adam.bankingapplication.Config;

import com.Adam.bankingapplication.DAO.CustomerDAO;
import com.Adam.bankingapplication.Entities.Customer;
import com.Adam.bankingapplication.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsernameAndPasswordAuthProvider implements AuthenticationProvider {

	@Autowired
	CustomerDAO customerDAO;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate (Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		List<Customer> customer = null;
			customer = customerDAO.getCustomerByEmail(username);
		if(customer.size() > 0) {
			if(passwordEncoder.matches(password, customer.get(0).getPassword())) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
				return new UsernamePasswordAuthenticationToken(username, password, authorities);
			} else {
				throw new BadCredentialsException("Invalid password!");
			}
		} else {
			throw new BadCredentialsException("Invalid email address entry: " + username);
		}
	}

	@Override
	public boolean supports (Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
