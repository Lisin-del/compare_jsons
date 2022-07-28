package ru.compare.app.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.compare.app.models.ProfileModel;
import ru.compare.app.models.ServerConfigModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
public class JsonComparator {
    @Autowired
    private JsonParser jsonParser;
    @Getter
    private HashMap<String, ServerConfigModel> models = new HashMap<>();
    @Autowired
    private UploadFilesInter uploadJson;
    String redColor = "#E36759";
    String greenColor = "#57E69B";
    String transparent = "transparent";

    /**
     * Compares two json files
     *
     * @param files Multipart files
     * @throws IOException
     */
    public void compare(MultipartFile... files) throws IOException {
        // uploading and parsing json files
        uploadJson.uploadFiles(files);
        models = jsonParser.parse();
        compareModels();
    }

    /**
     * Compares model from the Map models.
     * Adds colors to each model after the comparison.
     */
    public void compareModels() {
        ServerConfigModel serverConfigModel = models.get("model0");
        ServerConfigModel serverConfigModel1 = models.get("model1");

        if (!serverConfigModel.getServer().equals(serverConfigModel1.getServer())) {
            serverConfigModel.setServerColor(redColor);
            serverConfigModel1.setServerColor(greenColor);
        } else {
            serverConfigModel.setServerColor(transparent);
            serverConfigModel1.setServerColor(transparent);
        }

        if (!serverConfigModel.getIp().equals(serverConfigModel1.getIp())) {
            serverConfigModel.setServerIpColor(redColor);
            serverConfigModel1.setServerIpColor(greenColor);
        } else {
            serverConfigModel.setServerIpColor(transparent);
            serverConfigModel1.setServerIpColor(transparent);
        }

        if (!serverConfigModel.getDomain().equals(serverConfigModel1.getDomain())) {
            serverConfigModel.setDomainColor(redColor);
            serverConfigModel1.setDomainColor(greenColor);
        } else {
            serverConfigModel.setDomainColor(transparent);
            serverConfigModel1.setDomainColor(transparent);
        }

        List<ProfileModel> profiles = serverConfigModel.getProfiles();
        List<ProfileModel> profiles1 = serverConfigModel1.getProfiles();
        compareProfiles(profiles, profiles1, redColor);
        compareProfiles(profiles1, profiles, greenColor);

        models.put("model0", serverConfigModel);
        models.put("model1", serverConfigModel1);
    }

    /**
     * Compares profiles.
     * @param profiles list of profiles
     * @param profiles1 list of profiles
     * @param color color for a profile
     */
    private void compareProfiles(List<ProfileModel> profiles, List<ProfileModel> profiles1, String color) {
        for (ProfileModel profile : profiles) {
            boolean flagFound = false;

            for (ProfileModel profile1 : profiles1) {
                if (profile.getId().equals(profile1.getId())) {
                    flagFound = true;
                    profile.setIdColor(transparent);

                    if (!profile.getName().equals(profile1.getName())) {
                        profile.setNameColor(color);
                    } else {
                        profile.setNameColor(transparent);
                    }

                    if (!profile.getDriver().equals(profile1.getDriver())) {
                        profile.setDriverColor(color);
                    } else {
                        profile.setDriverColor(transparent);
                    }
                }
            }

            if (!flagFound) {
                profile.setIdColor(color);
                profile.setNameColor(color);
                profile.setDriverColor(color);
            }
        }

    }
}
