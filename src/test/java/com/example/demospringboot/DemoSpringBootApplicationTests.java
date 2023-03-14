package com.example.demospringboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.AssertTrue;

@SpringBootTest
class DemoSpringBootApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertTrue(true);
    }

}
