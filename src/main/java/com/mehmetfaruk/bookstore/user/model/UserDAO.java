package com.mehmetfaruk.bookstore.user.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDAO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private List<String> roles = new ArrayList<>();
}
