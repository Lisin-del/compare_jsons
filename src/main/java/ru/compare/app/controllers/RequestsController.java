package ru.compare.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.compare.app.App;
import ru.compare.app.services.UploadFiles;
import ru.compare.app.services.UploadFilesInter;
import ru.compare.app.services.UploadJsonFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class RequestsController {

    /**
     * Method <code>getHomePage</code> is needed for
     * handling GET requests.
     * @return HTML page
     */
    @GetMapping("/")
    public String getHomePage() {
        return "ftlh/Home";
    }

    @PostMapping("/upload")
    public String uploadFiles(
            @RequestParam("file1")MultipartFile file1,
            @RequestParam("file2") MultipartFile file2
    ) {
        UploadFilesInter uploadJson = App.context.getBean("uploadJsonFiles", UploadJsonFiles.class);
        try {
            uploadJson.uploadFiles(file1, file2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "ftlh/ResultUpload";
    }
}
