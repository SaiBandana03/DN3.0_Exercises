package com.bookstore;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstoreapi.controller.MockMvc;
import com.bookstoreapi.controller.Test;

@SpringBootTest
@AutoConfigureMockMvc
public class BookstoreIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetBooks() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(((Object) status()).isOk());
    }

    private Object status() {

        throw new UnsupportedOperationException("Unimplemented method 'status'");
    }

    private Object get(String string) {

        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
}
