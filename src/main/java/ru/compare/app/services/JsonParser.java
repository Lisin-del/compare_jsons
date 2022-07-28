package ru.compare.app.services;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.compare.app.models.ServerConfigModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class JsonParser {
    // mapper for parsing json to java
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Parses uploaded json files to the ServerConfigModel
     * @return {@code HashMap<String, ServerConfigModel>}
     * @throws IOException
     */
    public HashMap<String, ServerConfigModel> parse() throws IOException, DatabindException {
        // path to the directory for uploads
        HashMap<String, ServerConfigModel> models = new HashMap<>();
        List<Path> jsonFiles = Files.list(Paths.get("uploaded_files")).toList();

        for (int i = 0; i < 2; ++i) {
            ServerConfigModel model = mapper.readValue(Files.readString(jsonFiles.get(i)), ServerConfigModel.class);
            if (!model.getIp().isEmpty() && model.getIp() != null
                    && !model.getServer().isEmpty() && model.getServer() != null
                    && !model.getDomain().isEmpty() && model.getDomain() != null
                    && !model.getProfiles().isEmpty() && model.getProfiles() != null) {
                models.put("model" + i, model);
            }
            else {
                throw new IOException("The file structure is incorrect!");
            }
        }
        return models;
    }
}
