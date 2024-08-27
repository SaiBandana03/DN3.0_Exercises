package com.bookstore.dto;

import lombok.Data;

public class BookDTO extends RepresentationModel<BookDTO> {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private double price;

    public BookDTO(Long id, String title, String author, String isbn, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(id)).withSelfRel());
    }
}
