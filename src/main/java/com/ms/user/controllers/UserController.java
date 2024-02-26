package com.ms.user.controllers;

import com.ms.user.domain.user.User;
import com.ms.user.dtos.UserDTO;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO userDTO){
        var newUser = new User();
        BeanUtils.copyProperties(userDTO, newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.save(newUser));
    }

}
