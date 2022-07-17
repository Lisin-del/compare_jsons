package ru.compare.app.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadFilesInter {
    /**
     * Uploads json files
     *
     * @param files uploaded by users
     * @return boolean if files are uploaded successfully
     * @throws IOException
     */
    boolean uploadFiles(MultipartFile... files) throws IOException;

    /**
     * Clears the directory for uploads
     */
    void clearDirectory();
}
