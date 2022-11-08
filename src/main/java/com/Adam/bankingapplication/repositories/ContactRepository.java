package com.Adam.bankingapplication.repositories;

import com.Adam.bankingapplication.Entities.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
