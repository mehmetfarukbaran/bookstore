package com.mehmetfaruk.bookstore.book.controller;

import com.mehmetfaruk.bookstore.book.model.Book;
import com.mehmetfaruk.bookstore.book.model.BookDAO;
import com.mehmetfaruk.bookstore.book.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDAO>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }
    
    @GetMapping("/{isbn}")
    public ResponseEntity<BookDAO> getBookByIsbn(@PathVariable Long isbn){
        return ResponseEntity.ok(bookService.getBookByIsbn(isbn));
    }

    // TODO: 7.11.2023 admin only
    @PostMapping
    public ResponseEntity<BookDAO> newBook(@RequestBody BookDAO bookDAO){
        return ResponseEntity.ok(bookService.saveBook(bookDAO));
    }

    // TODO: 7.11.2023 admin only 
    @PutMapping("/{isbn}")
    public ResponseEntity<BookDAO> newBook(@PathVariable Long isbn){
        return ResponseEntity.ok(bookService.updateBook(isbn));
    }

    // TODO: 7.11.2023 admin only 
    @DeleteMapping("/{isbn}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable Long isbn){
        return ResponseEntity.ok(bookService.deleteBook(isbn));
    }

}
