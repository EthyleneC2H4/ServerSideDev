package com.example.contact.controller;

import com.example.contact.data.ContactRepository;
import com.example.contact.model.Contact;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RestController
@RequestMapping("/api")
public class WebAPIController {
    private ContactRepository contactRepository;

    @Autowired
    public WebAPIController( ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    ArrayList<Contact> contacts = new ArrayList<>();


    @ModelAttribute(name = "contact")
    public Contact contact(){return new Contact();}

    @ModelAttribute(name = "contacts")
    public ArrayList<Contact> contacts(){
        return contacts;
    }

    // 获取所有联系人信息的GET请求处理方法
    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = (List<Contact>) contactRepository.findAll();
        return ResponseEntity.ok(contacts); // 返回200 OK和联系人信息列表
    }

    // 获取指定id的联系人信息的GET请求处理方法
    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            return ResponseEntity.ok(contact); // 返回200 OK和联系人信息
        } else {
            return ResponseEntity.notFound().build(); // 返回404 Not Found
        }
    }

    // 创建新联系人信息的POST请求处理方法
    @PostMapping("/contact")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact createdContact = contactRepository.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContact); // 返回201 Created和创建的联系人信息
    }

    // 更新指定id的联系人信息的PUT请求处理方法
    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable("id") Long id, @RequestBody Contact contact) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            Contact existingContact = optionalContact.get();
            existingContact.setFirstName(contact.getFirstName());
            existingContact.setLastName(contact.getLastName());
            existingContact.setEmailAddress(contact.getEmailAddress());
            existingContact.setPhoneNumber(contact.getPhoneNumber());
            // 其他属性的更新

            Contact updatedContact = contactRepository.save(existingContact);
            return ResponseEntity.ok(updatedContact); // 返回200 OK和更新后的联系人信息
        } else {
            return ResponseEntity.notFound().build(); // 返回404 Not Found
        }
    }

    // 删除指定id的联系人信息的DELETE请求处理方法
    @DeleteMapping("/contact/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable("id") Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            contactRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 返回204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 返回404 Not Found
        }
    }
}
