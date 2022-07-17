package ru.compare.app.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.compare.app.models.ServerConfigModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class JsonComparator {
    @Autowired
    private JsonParser jsonParser;
    @Getter
    private HashMap<String, ServerConfigModel> models = new HashMap<>();

    public void compare() throws IOException {
        models = jsonParser.parse();

    }

}
