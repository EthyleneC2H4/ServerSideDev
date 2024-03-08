package annotation;

import example.Contact;
import example.ContactRepository;
import example.ContactRepositoryImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class AppendProcessor {
    @Around("@annotation(appendAnnotation)")
    public List<Contact> process(ProceedingJoinPoint joinPoint, Append appendAnnotation) throws Throwable {
        List<Contact> contacts=new ArrayList<>();
        Contact contact1 = new Contact();
        contact1.setId(1L);
        contact1.setFirstName("san");
        contact1.setLastName("zhang");
        contact1.setPhoneNumber("12345678901");
        contact1.setEmailAddress("zhangsan@163.com");
        contacts.add(contact1);

        Contact contact2 = new Contact();
        contact2.setId(2L);
        contact2.setFirstName("si");
        contact2.setLastName("li");
        contact2.setPhoneNumber("12345678902");
        contact2.setEmailAddress("lisi@163.com");
        contacts.add(contact2);
        return contacts;
    }
}
