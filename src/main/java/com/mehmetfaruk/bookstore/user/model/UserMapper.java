package com.mehmetfaruk.bookstore.user.model;

import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public UserDAO toDAO(User user){
        if (user == null) {
            return null;
        }

        UserDAO userDAO = new UserDAO();
        userDAO.setId(user.getId());
        userDAO.setUsername(user.getUsername());
        userDAO.setPassword(user.getPassword());

        return userDAO;
    }

    public User toEntity(UserDAO userDAO){
        if (userDAO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDAO.getId());
        user.setUsername(userDAO.getUsername());
        user.setPassword(userDAO.getPassword());

        return user;
    }
}
