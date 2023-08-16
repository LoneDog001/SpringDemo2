package com.example.springdemo.service;

import com.example.springdemo.repository.MyRepository;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    public String getProductName(String name) {
        return repository.getProductName(name);
    }
}
