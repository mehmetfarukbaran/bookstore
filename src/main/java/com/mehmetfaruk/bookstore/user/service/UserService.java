package com.mehmetfaruk.bookstore.user.service;

import com.mehmetfaruk.bookstore.user.model.User;
import com.mehmetfaruk.bookstore.user.model.UserDAO;
import com.mehmetfaruk.bookstore.user.model.UserMapper;
import com.mehmetfaruk.bookstore.user.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDAO signUp(UserDAO userDAO){
        userDAO.setPassword(passwordEncoder.encode(userDAO.getPassword()));
        return userMapper.toDAO(userRepository.save(userMapper.toEntity(userDAO)));
    }

    public void createAdminIfNoUser(String name, String password){
        if (userRepository.count() == 0){
            List<String> roles = new ArrayList<>();
            roles.add("ADMIN");
            User user = new User();
            user.setUsername(name);
            user.setPassword(password);
            user.setEmail("admin@admin.com");
            user.setRoles(roles);
            userRepository.save(user);
        }
    }

}
