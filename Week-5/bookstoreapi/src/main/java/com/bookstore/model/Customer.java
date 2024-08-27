package com.bookstore.model;

import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Size(min = 5, max = 100)
    private String email;

    @NotNull
    @Size(min = 10, max = 15)
    private String phoneNumber;

    @Version
    private Integer version;
}
