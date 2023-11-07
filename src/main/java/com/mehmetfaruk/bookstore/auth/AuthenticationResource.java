package com.mehmetfaruk.bookstore.auth;

import com.mehmetfaruk.bookstore.user.model.User;
import com.mehmetfaruk.bookstore.user.model.UserDAO;
import com.mehmetfaruk.bookstore.user.model.UserMapper;
import com.mehmetfaruk.bookstore.user.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthenticationResource {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping("/login")
    public ResponseEntity<UserDAO> login(){

        User user = userRepository.findByUsername(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName());

        return ResponseEntity.ok(userMapper.toDAO(user));
    }
}
