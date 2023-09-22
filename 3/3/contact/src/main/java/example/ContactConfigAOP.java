package example;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ContactConfigAOP {
    //实现一个切面，并且将切面植到getAll()方法的前面，调用getAll()时候会把该方法移到切面上面处理
    //将getAll()做了一个拦截
    @Bean
    public ContactRepository contactRepository(){
        return new ContactRepositoryImpl();
    }
    @Bean
    public ContactService contactService(ContactRepository contactRepository){
        return new ContactServiceImpl(contactRepository);
    }

    @Bean
    public Cache cache(){
        return new Cache();
    }

}
