package ru.compare.app.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileModel {
    private String name;
    private String driver;
    private String id;

    @Override
    public String toString() {
        return "ProfileModel{" +
                "name='" + name + '\'' +
                ", driver='" + driver + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
