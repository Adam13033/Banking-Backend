package com.Adam.bankingapplication.DAO;

import com.Adam.bankingapplication.Entities.Contact;
import com.Adam.bankingapplication.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Component
public class ContactDAO {

	@Autowired
	ContactRepository contactRepository;

	public Contact saveContactDetails(Contact contact) {
		if(contact != null) {
			contact.setContactId(getServiceReqNumber());
			contact.setCreateDt(new Date(System.currentTimeMillis()));
			return contactRepository.save(contact);
		}
		return null;
	}

	public String getServiceReqNumber() {
		Random random = new Random();
		int randNum = random.nextInt(999999999 - 9999) + 9999;
		return "SR" + randNum;
	}



}
