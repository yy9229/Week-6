package com.example.GreetingsApp.repository;

import com.example.GreetingsApp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}