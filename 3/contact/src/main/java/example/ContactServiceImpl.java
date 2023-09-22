package example;

import annotation.Append;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ContactServiceImpl implements ContactService{
    ContactRepository contactRepository;
    @Autowired
    ContactServiceImpl (ContactRepository contactRepository){
        this.contactRepository=contactRepository;
    }

    public List<Contact> getAll(){
        List<Contact> contacts = contactRepository.findAll();
        return contacts;
    }
    public void add(Contact contact){
        contactRepository.save(contact);
    }
}
