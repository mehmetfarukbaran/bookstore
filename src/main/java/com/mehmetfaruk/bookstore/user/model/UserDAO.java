package com.mehmetfaruk.bookstore.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class UserDAO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private List<String> books = new ArrayList<>();
}
