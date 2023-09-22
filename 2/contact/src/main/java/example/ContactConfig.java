package example;

import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ContactConfig {
    @Bean
    public ContactRepository contactRepository(){
        return new ContactRepositoryImpl();
    }
    @Bean
    public ContactService contactService(ContactRepository contactRepository){
        return new ContactServiceImpl(contactRepository);
    }
}
