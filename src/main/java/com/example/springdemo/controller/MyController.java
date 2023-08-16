package com.example.springdemo.controller;

import com.example.springdemo.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {
    private final MyService service;

    public MyController(MyService service){
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam(value = "name")String name){
        return service.getProductName(name);

    }



}
