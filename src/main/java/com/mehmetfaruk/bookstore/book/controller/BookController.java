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

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<BookDAO> newBook(@RequestBody BookDAO bookDAO){
        return ResponseEntity.ok(bookService.saveBook(bookDAO));
    }

    @PutMapping("/{isbn}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<BookDAO> updateBook(@PathVariable Long isbn, @RequestBody BookDAO bookDAO){
        return ResponseEntity.ok(bookService.updateBook(isbn,bookDAO));
    }

    @DeleteMapping("/{isbn}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteBook(@PathVariable Long isbn){
        bookService.deleteBook(isbn);
        return ResponseEntity.ok().build();
    }

}
