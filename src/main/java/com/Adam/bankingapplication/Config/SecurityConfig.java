package com.Adam.bankingapplication.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.sql.DataSource;
import java.security.SecureRandom;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain (HttpSecurity http) throws Exception {
		http.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		http.formLogin()
						.defaultSuccessUrl("/");
		http.authorizeRequests()
				.antMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
				.antMatchers("/notices", "/contact", "/register").permitAll()
				.and().formLogin()
				.and().httpBasic();
		return http.build();
	}





	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(15, new SecureRandom());
	}

}
