package com.mehmetfaruk.bookstore.book.repo;

import com.mehmetfaruk.bookstore.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findByOrderByCreatedDateDesc(Pageable pageable);
    Book findByIsbn(Long isbn);
    void deleteByIsbn(Long isbn);
}
