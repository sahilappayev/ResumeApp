package com.mycompany.repository;

import com.mycompany.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//Spring Data

public interface UserRepository  extends JpaRepository<User , Integer> {

    User findByName(String name);

    @Query(value = "select u from User u where u.email = ?1")
    User findByEmail(/*@Param("email")*/ String email);

}
