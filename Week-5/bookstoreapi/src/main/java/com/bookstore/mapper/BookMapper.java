package com.bookstore.mapper;

import com.bookstore.dto.BookDTO;
import com.bookstore.model.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toDTO(Book book);

    Book toEntity(BookDTO bookDTO);
}
