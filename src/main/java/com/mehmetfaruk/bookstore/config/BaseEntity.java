package com.mehmetfaruk.bookstore.config;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

public class BaseEntity {

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}
