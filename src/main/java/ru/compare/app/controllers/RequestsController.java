package ru.compare.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.compare.app.services.JsonComparator;
import java.io.IOException;

@Controller
public class RequestsController {
    @Autowired
    private JsonComparator jsonComparator;

    /**
     * Gets and handles GET requests
     *
     * @return HTML page
     */
    @GetMapping("/")
    public String getHomePage() {
        return "ftlh/Home";
    }

    /**
     * Gets and handles POST requests /upload
     * @param file1
     * @param file2
     * @return HTML page
     */
    @PostMapping("/compare")
    public String compareFiles(
            @RequestParam("file1") MultipartFile file1,
            @RequestParam("file2") MultipartFile file2, Model model
    ) {
        try {
            if (!file1.isEmpty()
                    && !file2.isEmpty()
                    && file1.getContentType().equals("application/json")
                    && file2.getContentType().equals("application/json")
            ) {
                jsonComparator.compare(file1, file2);
            } else {
                return "ftlh/ErrorEmptyFiles";
            }
        } catch (IOException e) {
            System.out.println("Failed uploading or parsing json files: " + e.getMessage());
        }
        return "ftlh/ResultUpload";
    }
}
