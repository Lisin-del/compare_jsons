package ru.compare.app.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadJsonFiles implements UploadFilesInter {

    @Override
    public boolean uploadFiles(MultipartFile... files) throws IOException {
        boolean flagExisting = true;

        Path uploaded_files = Paths.get("uploaded_files");
        if (Files.isDirectory(uploaded_files)) {
            clearDirectory();
            moveMultipartFiles(files);
        }
        else {
            Files.createDirectory(uploaded_files);
            clearDirectory();
            moveMultipartFiles(files);
        }
        return flagExisting;
    }

    @Override
    public void clearDirectory() {
        File dir = new File("uploaded_files");
        File[] listFiles = dir.listFiles();

        if (listFiles.length != 0) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    private void moveMultipartFiles(MultipartFile...files) throws IOException {
        for (MultipartFile file : files) {
            // generate unique name for uploaded file
            Path path = Paths.get("uploaded_files/" + UUID.randomUUID() + ".json");
            Files.createFile(path);
            file.transferTo(path);
        }
    }
}
