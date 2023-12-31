package com.mehmetfaruk.bookstore.book.model;

import com.mehmetfaruk.bookstore.config.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Data
@Table
@Entity
@EntityListeners({AuditingEntityListener.class})
//@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity implements Serializable {

    @Id
    @Column
    @GeneratedValue(generator = "book_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "book_gen", sequenceName = "book_seq", initialValue = 1000000)
    private Long isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Long stockQuantity;

}
