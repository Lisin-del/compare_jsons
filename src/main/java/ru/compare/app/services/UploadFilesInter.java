package ru.compare.app.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadFilesInter {
    boolean uploadFiles(MultipartFile... files) throws IOException;

    void clearDirectory();
}
