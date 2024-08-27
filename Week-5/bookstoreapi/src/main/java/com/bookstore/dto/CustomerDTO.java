package com.bookstore.dto;

import lombok.Data;

@Data
public class CustomerDTO extends RepresentationModel<CustomerDTO> {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

    public CustomerDTO(Long id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        add(WebMvcLinkBuilder
                .linkTo(((Object) WebMvcLinkBuilder.methodOn(CustomerController.class)).getCustomerById(id))
                .withSelfRel());
    }
}
