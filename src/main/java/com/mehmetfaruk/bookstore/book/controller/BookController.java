package com.mehmetfaruk.bookstore.book.controller;

import com.mehmetfaruk.bookstore.book.model.BookDAO;
import com.mehmetfaruk.bookstore.book.service.BookService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
@SecurityRequirement(name = "bookstoreapi")
public class BookController {

    private final BookService bookService;

    @GetMapping
    @RateLimiter(name = "getBooksRateLimiter")
    public ResponseEntity<List<BookDAO>> getBooks(Pageable pageable){
        return ResponseEntity.ok(bookService.getBooks(pageable));
    }
    
    @GetMapping("/{isbn}")
    public ResponseEntity<BookDAO> getBookByIsbn(@PathVariable Long isbn){
        return ResponseEntity.ok(bookService.getBookByIsbn(isbn));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(description = "Only users which has 'ADMIN' role can access this endpoint. Please check your roles before send a request.")
    public ResponseEntity<BookDAO> newBook(@RequestBody BookDAO bookDAO){
        return ResponseEntity.ok(bookService.saveBook(bookDAO));
    }

    @PutMapping("/{isbn}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(description = "Only users which has 'ADMIN' role can access this endpoint. Please check your roles before send a request.")
    public ResponseEntity<BookDAO> updateBook(@PathVariable Long isbn, @RequestBody BookDAO bookDAO) throws Exception {
        return ResponseEntity.ok(bookService.updateBook(isbn,bookDAO));
    }

    @DeleteMapping("/{isbn}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(description = "Only users which has 'ADMIN' role can access this endpoint. Please check your roles before send a request.")
    public ResponseEntity<Void> deleteBook(@PathVariable Long isbn){
        bookService.deleteBook(isbn);
        return ResponseEntity.ok().build();
    }

}
