package ru.compare.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetController {
    @GetMapping("/")
    public String getHomePage() {
        return "html/Home.html";
    }
}
