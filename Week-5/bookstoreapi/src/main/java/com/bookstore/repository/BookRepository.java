package com.bookstore.repository;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    Object findAll();

    Optional<Book> findById(Long id);

    void delete(Book book);

    Book save(Book book);

    @GetMapping("/{id}")
    default ResponseEntity<Book> getBookById(Long id) {
        Optional<Book> book = findById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}