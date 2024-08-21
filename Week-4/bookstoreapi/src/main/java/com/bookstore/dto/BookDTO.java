package com.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDTO {
    private Long id;

    @JsonProperty("book_title")
    private String title;

    private String author;

    @JsonIgnore
    private String isbn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String publisher;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate publicationDate;

    private double price;
}
