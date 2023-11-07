package com.mehmetfaruk.bookstore.user.service;

import com.mehmetfaruk.bookstore.user.model.UserDAO;
import com.mehmetfaruk.bookstore.user.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDAO signUp(UserDAO userDAO){
        return null;
    }

    public UserDAO login(UserDAO userDAO){
        return null;
    }
    // `POST /users/signup`: Register a new user.
    //- `POST /users/login`: Authenticate a user and return a token (JWT
    //preferred).
}
