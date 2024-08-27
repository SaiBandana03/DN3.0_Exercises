package com.bookstore.model;

import lombok.Data;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String title;

    @NotNull
    @Size(min = 2, max = 50)
    private String author;

    @NotNull
    @Min(1)
    private Double price;

    @NotNull
    private String isbn;

    @Version
    private Integer version;
}
