package uz.mohirdev.lesson.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import uz.mohirdev.lesson.entity.Counties;

import javax.persistence.ManyToMany;
import java.time.Instant;
import java.util.List;

public class Holiday {
    private Long id;
//    @JsonFormat(pattern="yyyy-MM-dd")
    private String date;
    private String localName;
    private String name;
    private String countryCode;
    private Boolean fixed ;
    private Boolean global;
    @ManyToMany
    private List<Counties> counties;
    private String launchYear;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Boolean getFixed() {
        return fixed;
    }

    public void setFixed(Boolean fixed) {
        this.fixed = fixed;
    }

    public Boolean getGlobal() {
        return global;
    }

    public void setGlobal(Boolean global) {
        this.global = global;
    }

    public List<Counties> getCounties() {
        return counties;
    }

    public void setCounties(List<Counties> counties) {
        this.counties = counties;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
