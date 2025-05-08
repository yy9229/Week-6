package com.example.GreetingsApp.service;

import com.example.GreetingsApp.model.Greeting;
import com.example.GreetingsApp.model.User;
import com.example.GreetingsApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService implements IGreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting getGreetingMessage(User user) {
        String message;
        if (user.getFirstName() != null && user.getLastName() != null) {
            message = "Hello " + user.getFirstName() + " " + user.getLastName();
        } else if (user.getFirstName() != null) {
            message = "Hello " + user.getFirstName();
        } else if (user.getLastName() != null) {
            message = "Hello " + user.getLastName();
        } else {
            message = "Hello World";
        }
        return new Greeting(message);
    }

    @Override
    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    @Override
    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting editGreeting(Long id, String newMessage) {
        Optional<Greeting> greetingOpt = greetingRepository.findById(id);
        if (greetingOpt.isPresent()) {
            Greeting greeting = greetingOpt.get();
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        }
        return null;
    }

    @Override
    public void deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
    }
}
