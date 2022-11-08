package com.Adam.bankingapplication.Controller;

import com.Adam.bankingapplication.DAO.ContactDAO;
import com.Adam.bankingapplication.Entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class ContactController {

	@Autowired
	ContactDAO contactDAO;

	@GetMapping("/contact")
	public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
		return contactDAO.saveContactDetails(contact);
	}

}
