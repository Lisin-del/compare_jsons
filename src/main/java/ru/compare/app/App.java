package ru.compare.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            "ru.compare.app.controllers",
            "ru.compare.app.models",
            "ru.compare.app.services"
    );
}
