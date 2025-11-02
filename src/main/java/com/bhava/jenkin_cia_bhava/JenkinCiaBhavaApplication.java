package com.bhava.jenkin_cia_bhava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinCiaBhavaApplication {

    @GetMapping("/")
    public String home() {
        return "Hello from Bhava's CI/CD Pipeline 🚀";
    }

    public static void main(String[] args) {
        SpringApplication.run(JenkinCiaBhavaApplication.class, args);
    }
}
