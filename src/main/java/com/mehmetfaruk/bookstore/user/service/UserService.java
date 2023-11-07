package com.mehmetfaruk.bookstore.user.service;

import com.mehmetfaruk.bookstore.user.model.User;
import com.mehmetfaruk.bookstore.user.model.UserDAO;
import com.mehmetfaruk.bookstore.user.model.UserMapper;
import com.mehmetfaruk.bookstore.user.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDAO signUp(UserDAO userDAO){
        return userMapper.toDAO(userRepository.save(userMapper.toEntity(userDAO)));
    }

    public void createAdminIfNoUser(){
        if (userRepository.count() == 0){
            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");
            userRepository.save(user);
        }
    }
    // `POST /users/signup`: Register a new user.
    //- `POST /users/login`: Authenticate a user and return a token (JWT
    //preferred).
}
