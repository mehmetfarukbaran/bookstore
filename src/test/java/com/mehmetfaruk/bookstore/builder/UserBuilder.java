package com.mehmetfaruk.bookstore.builder;

import com.mehmetfaruk.bookstore.user.model.UserDAO;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class UserBuilder {

    private final UserDAO userDAO = new UserDAO();

    public UserBuilder buildMockObject(){
        this.userDAO.setUsername("admin");
        this.userDAO.setPassword("admin");
        this.userDAO.setEmail("admin@admin.com");
        this.userDAO.setRoles(generateAdminRole());

        return this;
    }

    public UserBuilder withUsername(String username){
        this.userDAO.setUsername(username);
        return this;
    }

    public UserBuilder withPassword(String password){
        this.userDAO.setPassword(password);
        return this;
    }

    public UserBuilder withRoles(List<String> roles){
        this.userDAO.setRoles(roles);
        return this;
    }

    public UserDAO build(){
        return this.userDAO;
    }

    public List<String> generateAdminRole(){
        List<String> roleList = new ArrayList<>();
        roleList.add("ADMIN");
        return roleList;
    }
}
