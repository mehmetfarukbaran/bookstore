package com.mehmetfaruk.bookstore.book.repo;

import com.mehmetfaruk.bookstore.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
