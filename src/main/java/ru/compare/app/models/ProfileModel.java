package ru.compare.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class ProfileModel {
    private String name;
    private String driver;
    private String id;
    @JsonIgnore
    @Setter
    private String nameColor;
    @JsonIgnore
    @Setter
    private String driverColor;
    @JsonIgnore
    @Setter
    private String idColor;

    @Override
    public String toString() {
        return "ProfileModel{" +
                "name='" + name + '\'' +
                ", driver='" + driver + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileModel that = (ProfileModel) o;
        return name.equals(that.name) && driver.equals(that.driver) && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, driver, id);
    }
}
