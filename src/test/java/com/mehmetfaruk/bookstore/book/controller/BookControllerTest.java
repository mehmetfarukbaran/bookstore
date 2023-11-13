package com.mehmetfaruk.bookstore.book.controller;

import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.*;

class BookControllerTest {

    @Test
    void getBooks() {
    }

    @Test
    void getBookByIsbn() {
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void newBook() {
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void updateBook() {
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void deleteBook() {
    }
}