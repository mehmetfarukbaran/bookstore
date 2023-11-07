package com.mehmetfaruk.bookstore.user.model;

import com.mehmetfaruk.bookstore.config.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Data
public class User extends BaseEntity {

    @Id
    @Column
    @GeneratedValue(generator = "user_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", initialValue = 1000)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String email;

    @Column(columnDefinition = "String[]")
    @ElementCollection
    private List<String> roles = new ArrayList<>();
}
