package com.mehmetfaruk.bookstore.book.controller;

import com.mehmetfaruk.bookstore.book.model.BookDAO;
import com.mehmetfaruk.bookstore.book.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDAO>> getBooks(Pageable pageable){
        return ResponseEntity.ok(bookService.getBooks(pageable));
    }
    
    @GetMapping("/{isbn}")
    public ResponseEntity<BookDAO> getBookByIsbn(@PathVariable Long isbn){
        return ResponseEntity.ok(bookService.getBookByIsbn(isbn));
    }

    // TODO: 7.11.2023 admin only
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<BookDAO> newBook(@RequestBody BookDAO bookDAO){
        return ResponseEntity.ok(bookService.saveBook(bookDAO));
    }

    // TODO: 7.11.2023 admin only 
    @PutMapping("/{isbn}")
    public ResponseEntity<BookDAO> updateBook(@PathVariable Long isbn){
        return ResponseEntity.ok(bookService.updateBook(isbn));
    }

    // TODO: 7.11.2023 admin only 
    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long isbn){
        bookService.deleteBook(isbn);
        return ResponseEntity.ok().build();
    }

}
