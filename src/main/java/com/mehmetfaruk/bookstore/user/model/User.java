package com.mehmetfaruk.bookstore.user.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Table
@Entity
@Data
public class User {

    @Id
    @Column
    @GeneratedValue(generator = "user_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", initialValue = 1000)
    private Long id;
    private String name;
    private String password;
    private String email;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updateAt;

    //Name, Email, Password (encrypted), CreatedAt, UpdatedAt.
}
