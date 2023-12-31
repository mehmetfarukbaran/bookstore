package com.mehmetfaruk.bookstore.user.controller;

import com.mehmetfaruk.bookstore.user.model.User;
import com.mehmetfaruk.bookstore.user.model.UserDAO;
import com.mehmetfaruk.bookstore.user.model.UserMapper;
import com.mehmetfaruk.bookstore.user.repo.UserRepository;
import com.mehmetfaruk.bookstore.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
@SecurityRequirement(name = "bookstoreapi")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @PostMapping("/signUp")
    @Operation(description = "To access all endpoints, you must send a user with 'ADMIN' role.")
    public ResponseEntity<UserDAO> signUp(@RequestBody @Parameter(description = "User to save") UserDAO userDAO){
        return ResponseEntity.ok(userService.signUp(userDAO));
    }

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
