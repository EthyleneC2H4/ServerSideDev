package example;

import annotation.Append;

import java.util.List;

public interface ContactService {

    List<Contact> getAll();

    void add(Contact contact);
}
