package com.bookstore.mapper;

import com.bookstore.dto.CustomerDTO;
import com.bookstore.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);

    Customer toEntity(CustomerDTO customerDTO);
}
