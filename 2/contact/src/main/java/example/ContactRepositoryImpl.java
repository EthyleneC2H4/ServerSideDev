package example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactRepositoryImpl implements ContactRepository{
    public List<Contact> contacts = new ArrayList<Contact>();
    public List<Contact> findAll(){
        return contacts;
    }
    public void save(Contact contact){
        contacts.add(contact);
    }
    public void clear(){
        contacts.clear();
    }
}
