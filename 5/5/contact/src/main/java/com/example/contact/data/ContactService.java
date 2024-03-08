package com.example.contact.data;

import com.example.contact.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAll();

    void add(Contact contact);
}
