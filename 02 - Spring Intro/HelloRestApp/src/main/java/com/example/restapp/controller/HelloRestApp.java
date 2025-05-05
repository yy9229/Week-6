package com.example.restapp.controller;

import com.example.restapp.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRestApp {

    @GetMapping("/hello")
    public String basicHello() {
        return "Hello from BridgeLabz";
    }

    @GetMapping("/hello/query")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    @GetMapping("/hello/param/{name}")
    public String helloWithPathVariable(@PathVariable String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    @PostMapping("/hello/post")
    public String helloWithPostBody(@RequestBody User user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + " from BridgeLabz";
    }

    @PutMapping("/hello/put/{firstName}")
    public String helloWithPutParams(
            @PathVariable String firstName,
            @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName + " from BridgeLabz";
    }
}

