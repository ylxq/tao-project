package com.cn;

import com.cn.domain.Person;
import com.cn.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tao_wc
 * @date 2018/1/19
 */
@SpringBootApplication
@Controller
public class Application {

    @Autowired
    private PersonMapper personMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @GetMapping("/")
    @ResponseBody
    public String index() {
        Person p = personMapper.findOne(1L);
        return "hello " + p.getFirstName();
    }

}