package ru.compare.app.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public abstract class UploadFiles implements UploadFilesInter {
    @Override
    public abstract boolean uploadFiles(MultipartFile... files) throws IOException;
}
