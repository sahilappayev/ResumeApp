package com.mycompany.controller;

import com.mycompany.dto.ResponseDTO;
import com.mycompany.dto.UserDTO;
import com.mycompany.entity.User;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersRestContoller {

    @Autowired
    UserServiceInter userService;

    @GetMapping(value = "/users")
    public ResponseEntity<ResponseDTO> getUsers(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "age", required = false) Integer age) {
        List<User> users = userService.getAll(name, surname, age);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User u : users) {
            userDTOS.add(new UserDTO(u));
        }
        return ResponseEntity.ok(ResponseDTO.of(userDTOS));
//        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") int id) {
        User u = userService.getById(id);
        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(u)));
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id) {
        User u = userService.getById(id);
        userService.delete(id);
        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(u), "Successfully deleted!"));
    }

    @PostMapping(value = "/users")
    public ResponseEntity<ResponseDTO> deleteUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setAge(userDTO.getAge());
        userService.update(user);
        return ResponseEntity.ok(ResponseDTO.of(userDTO, "Successfully added!"));
    }

}
