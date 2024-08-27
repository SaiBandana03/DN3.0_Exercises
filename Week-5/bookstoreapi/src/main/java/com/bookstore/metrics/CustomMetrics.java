package com.bookstore.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    @Autowired
    public CustomMetrics(MeterRegistry registry) {
        registry.counter("bookstore.books.total");
    }
}
