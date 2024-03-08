package com.example.contact.data;

import com.example.contact.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContactRepository extends CrudRepository<Contact,Long>{
    List<Contact> findAll();

    //void save(Contact contact);

    void clear();

}
