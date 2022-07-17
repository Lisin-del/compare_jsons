package ru.compare.app.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ServerConfigModel {
    private String server;
    private String ip;
    private String domain;
    private List<ProfileModel> profiles;

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
