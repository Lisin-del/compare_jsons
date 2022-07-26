package ru.compare.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
@Getter
public class ServerConfigModel {
    private String server;
    private String ip;
    private String domain;
    private List<ProfileModel> profiles;
    @JsonIgnore
    @Setter
    private String serverColor;
    @JsonIgnore
    @Setter
    private String serverIpColor;
    @JsonIgnore
    @Setter
    private String domainColor;

    @Override
    public String toString() {
        return "ServerConfigModel{" +
                "server='" + server + '\'' +
                ", ip='" + ip + '\'' +
                ", domain='" + domain + '\'' +
                ", profiles=" + profiles +
                '}';
    }
}
