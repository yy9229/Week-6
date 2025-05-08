package com.example.GreetingsApp.controllers;

import com.example.GreetingsApp.model.Greeting;
import com.example.GreetingsApp.model.User;
import com.example.GreetingsApp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/hello")
    public Greeting getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        User user = new User(firstName, lastName);
        return greetingService.getGreetingMessage(user);
    }

    @PostMapping
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting);
    }

    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    @GetMapping
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/{id}")
    public Greeting editGreeting(@PathVariable Long id, @RequestBody String newMessage) {
        return greetingService.editGreeting(id, newMessage);
    }

    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return "Deleted greeting with id: " + id;
    }
}
