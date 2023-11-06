package com.mehmetfaruk.bookstore.book.service;

import com.mehmetfaruk.bookstore.book.repo.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
}
