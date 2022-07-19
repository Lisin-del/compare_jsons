package ru.compare.app.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.compare.app.models.ServerConfigModel;

import java.io.IOException;
import java.util.HashMap;

@Service
public class JsonComparator {
    @Autowired
    private JsonParser jsonParser;
    @Getter
    private HashMap<String, ServerConfigModel> models = new HashMap<>();
    @Autowired
    private UploadFilesInter uploadJson;

    /**
     * Compares two json files
     * @param files Multipart files
     * @throws IOException
     */
    public void compare(MultipartFile...files) throws IOException {
        // uploading and parsing json files
        uploadJson.uploadFiles(files);
        models = jsonParser.parse();


    }

}
