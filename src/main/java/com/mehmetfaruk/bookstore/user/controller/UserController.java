package com.mehmetfaruk.bookstore.user.controller;

import com.mehmetfaruk.bookstore.user.model.UserDAO;
import com.mehmetfaruk.bookstore.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<UserDAO> signUp(@RequestBody UserDAO userDAO){
        return ResponseEntity.ok(userService.signUp(userDAO));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDAO> login(@RequestBody UserDAO userDAO){
        return ResponseEntity.ok(userService.login(userDAO));
    }
}
