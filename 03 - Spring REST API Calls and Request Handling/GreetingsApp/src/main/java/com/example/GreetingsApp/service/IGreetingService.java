package com.example.GreetingsApp.service;

import com.example.GreetingsApp.model.Greeting;
import com.example.GreetingsApp.model.User;

import java.util.List;
import java.util.Optional;

public interface IGreetingService {
    Greeting getGreetingMessage(User user);
    Greeting saveGreeting(Greeting greeting);
    Optional<Greeting> getGreetingById(Long id);
    List<Greeting> getAllGreetings();
    Greeting editGreeting(Long id, String newMessage);
    void deleteGreeting(Long id);
}
