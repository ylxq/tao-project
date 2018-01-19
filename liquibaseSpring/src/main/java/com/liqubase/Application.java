package com.liqubase;

import com.liqubase.domain.Person;
import com.liqubase.repository.PersonRepository;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;

@SpringBootApplication
@Controller
public class Application {

    @Autowired
    private PersonRepository repository;


    /**
     * spring  data jpa 声明式  事务
     * 异常抛出 自动回滚
     *
     * @return
     */
    @GetMapping("/")
    @ResponseBody
    @Transactional(rollbackOn = Exception.class)
    public String index() {

        Person person = new Person();
        person.setFirstname("张");
        repository.save(person);
        if (true) {
            throw new NullPointerException("test");
        }
        Person p = new Person();
        p.setFirstname("李");
        repository.save(p);
        return "hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
