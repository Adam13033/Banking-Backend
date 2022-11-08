package com.Adam.bankingapplication.Validation;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;

import java.util.regex.Pattern;

public class Validator {

	public static boolean isEmailValid (String email) {
		return email.matches("(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
	}

	/**
	 *
	 * @param password Customer's password
	 * @return returns boolean, true if the password is min 8 characters IF
	 *  - Contains both upper and lower case characters
	 *  - Includes number(s)
	 *  - Includes a special character
	 */
	public static boolean isPasswordValid(String password) {
		Pattern pattern = Pattern.compile("^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[@#$%^&+=!])"
				+ "(?=\\S+$).{8,20}$");
		System.out.println("Testing password inside of validate password: " + password);
		return password.matches(String.valueOf(pattern));
	}
}
