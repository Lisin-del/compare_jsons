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
                model.addAttribute("modelName1", file1.getName());
                model.addAttribute("modelName2", file2.getName());
                model.addAttribute("serverConfigModel", jsonComparator.getModels().get("model0"));
                model.addAttribute("serverConfigModel1", jsonComparator.getModels().get("model1"));
                model.addAttribute("profiles", jsonComparator.getModels().get("model0").getProfiles());
                model.addAttribute("profiles1", jsonComparator.getModels().get("model1").getProfiles());

            } else {
                return "ftlh/ErrorEmptyFiles";
            }
        } catch (IOException e) {
            System.out.println("Failed uploading or parsing json files: " + e.getMessage());
            return "ftlh/ErrorEmptyFiles";
        }
        return "ftlh/ResultCompare";
    }
}
