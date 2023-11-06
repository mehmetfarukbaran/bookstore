package com.mehmetfaruk.bookstore.user.service;

import com.mehmetfaruk.bookstore.user.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
}
