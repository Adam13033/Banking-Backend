//package com.Adam.bankingapplication.Config;
//
//import com.Adam.bankingapplication.Entities.Customer;
//import com.Adam.bankingapplication.repositories.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserDetailServices implements UserDetailsService {
//
//	@Autowired
//	CustomerRepository customerRepository;
//
//	@Autowired
//	PasswordEncoder passwordEncoder;
//
//	@Override
//	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
//		String userName, password = null;
//		List<GrantedAuthority> authorities = null;
//		List<Customer> customer = customerRepository.findByEmail(username);
//
//		if(customer.size() == 0) {
//			throw new UsernameNotFoundException("No details located for username: " + username);
//		} else {
//			userName = customer.get(0).getEmail();
//			password = customer.get(0).getPassword();
//			authorities = new ArrayList<>();
//			authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
//		}
//		User newUser = new User(userName, password, authorities);
//		return newUser;
//	}
//}
