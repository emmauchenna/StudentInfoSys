package com.kloudvistas.domains;

import java.time.LocalDateTime;

public class Faculty extends Base{

    private String name;
    private String shortName;

    public Faculty(int id, LocalDateTime createdDate, String createdBy, LocalDateTime updatedDated, String updatedBy, String name, String shortName) {
        super(id, createdDate, createdBy, updatedDated, updatedBy);
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
