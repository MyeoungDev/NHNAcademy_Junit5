package org.example.tdd;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {
    @Test
    @Order(2)
    void nullValues() {
    }

    @Test
    @Order(1)
    void emptyValues() {
    }

    @Test
    @Order(3)
    void validValues() {
    }
}
