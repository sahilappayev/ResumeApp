package com.mycompany;

import com.mycompany.entity.User;
import com.mycompany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class Main {

    @Autowired
    UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
//                User u = userRepository.findByEmail("sahilappayev@gmail.com");
//                System.out.println(u.getName() + " "+ u.getSurname());


            }
        };
        return clr;
    }
}
