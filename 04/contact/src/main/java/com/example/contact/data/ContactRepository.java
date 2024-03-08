package com.example.contact.data;

import com.example.contact.model.Contact;

import java.util.List;

public interface ContactRepository {
    List<Contact> findAll();

    void save(Contact contact);

    void clear();
}
