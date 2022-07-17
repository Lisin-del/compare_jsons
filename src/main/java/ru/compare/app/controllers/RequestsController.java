package ru.compare.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.compare.app.App;
import ru.compare.app.services.JsonComparator;
import ru.compare.app.services.UploadFilesInter;
import ru.compare.app.services.UploadJsonFiles;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class RequestsController {

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
    @PostMapping("/upload")
    public String uploadFiles(
            @RequestParam("file1") MultipartFile file1,
            @RequestParam("file2") MultipartFile file2, Model model
    ) {
        UploadFilesInter uploadJson = App.context.getBean("uploadJsonFiles", UploadJsonFiles.class);
        JsonComparator jsonComparator = App.context.getBean("jsonComparator", JsonComparator.class);

        try {
            uploadJson.clearDirectory();
            if (!file1.isEmpty() && !file2.isEmpty()
                    && file1.getContentType().equals("application/json")
                    && file2.getContentType().equals("application/json")) {

                uploadJson.uploadFiles(file1, file2);
                jsonComparator.compare();
                model.addAttribute("fileName1", file1.getName());
                model.addAttribute("fileName2", file2.getName());
                model.addAttribute("serverName",
                        jsonComparator.getModels().get("file0").getServer());
                model.addAttribute("serverIp",
                        jsonComparator.getModels().get("file0").getIp());
                model.addAttribute("domainName",
                        jsonComparator.getModels().get("file0").getDomain());
                model.addAttribute("profiles",
                        jsonComparator.getModels().get("file0").getProfiles());

            } else {
                return "ftlh/ErrorEmptyFiles";
            }
        } catch (IOException e) {
            System.out.println("Failed uploading or parsing json files: " + e.getMessage());
        }
        return "ftlh/ResultCompare";
    }
}
