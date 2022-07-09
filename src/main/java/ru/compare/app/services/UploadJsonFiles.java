package ru.compare.app.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadJsonFiles extends UploadFiles{

    @Override
    public boolean uploadFiles(MultipartFile... files) throws IOException {
        boolean flagExisting = true;

        if (Files.isDirectory(Paths.get("uploaded_files"))) {
            for(MultipartFile file : files) {
                // generate unique name for uploaded file
                Path path = Paths.get("uploaded_files/" + UUID.randomUUID() + ".json");

                Files.createFile(path);
                file.transferTo(path);

                if (!Files.exists(path)) {
                    return false;
                }
            }
        }
        return flagExisting;
    }
}
