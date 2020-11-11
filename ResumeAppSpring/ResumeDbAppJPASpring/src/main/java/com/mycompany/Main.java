package com.mycompany;

import com.mycompany.entity.User;
import com.mycompany.repository.UserRepository;
import com.mycompany.service.impl.UserServiceImpl;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableCaching
public class Main {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceInter userService;


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                User u = userRepository.findByEmail("faiqpenahov@gmail.com");
//                System.out.println(u.getName() + " "+ u.getSurname());
//                userService.resetPassword(u, "Faiq");
            }
        };
        return clr;
    }
}
