package com.bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    public BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookRepository.getBookById(id);
    }

    @PostMapping
    public Book createBook(@Validated @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Validated @RequestBody Book bookDetails) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            book.setIsbn(bookDetails.getIsbn());
            return ResponseEntity.ok(bookRepository.save(book));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long id) {
        return bookRepository.findById(id).map(book -> {
            bookRepository.delete(book);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get all books", description = "Returns a list of all books.")
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Operation(summary = "Get a book by ID", description = "Returns a single book by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
