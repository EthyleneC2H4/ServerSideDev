package com.example.contact.data;


import com.example.contact.model.Contact;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Cache{
    @Pointcut("execution(* com.example.contact.data.ContactService.getAll( .. ))")
    public void getAll(){}
    @Before("getAll()")
    public void cache(JoinPoint joinPoint){
        ContactService contactService =(ContactServiceImpl)joinPoint.getTarget();
        Contact contact1 = new Contact();
        contact1.setId(1L);
        contact1.setFirstName("san");
        contact1.setLastName("zhang");
        contact1.setPhoneNumber("12345678901");
        contact1.setEmailAddress("zhangsan@163.com");
        contactService.add(contact1);

        Contact contact2 = new Contact();
        contact2.setId(2L);
        contact2.setFirstName("si");
        contact2.setLastName("li");
        contact2.setPhoneNumber("12345678902");
        contact2.setEmailAddress("lisi@163.com");
        contactService.add(contact2);

    }

}
