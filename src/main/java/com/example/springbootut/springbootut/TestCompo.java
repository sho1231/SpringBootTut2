package com.example.springbootut.springbootut;

import org.springframework.stereotype.Component;

@Component
public class TestCompo {
    public TestCompo() {
        System.out.println("Default constructor called");
    }
    String a;
}
