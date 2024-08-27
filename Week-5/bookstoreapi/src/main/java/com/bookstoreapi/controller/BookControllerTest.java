package com.bookstoreapi.controller;

import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collections;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void testGetAllBooks() throws Exception {
        ((Object) Mockito.when(bookRepository.findAll())).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/books"))
                .andExpect(((Object) status()).isOk());
    }

    private Object get(String string) {

        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    private Object status() {

        throw new UnsupportedOperationException("Unimplemented method 'status'");
    }
}
