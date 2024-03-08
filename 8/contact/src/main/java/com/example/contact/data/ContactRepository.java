package com.example.contact.data;

import com.example.contact.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository
        extends CrudRepository<Contact,Long>{

}
