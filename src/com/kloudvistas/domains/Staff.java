package com.kloudvistas.domains;

import java.time.LocalDateTime;

public class Staff extends Base {
    private String name;
    private String qualification;
    private String status;

    public Staff(int id, LocalDateTime createdDate, String createdBy, LocalDateTime updatedDated, String updatedBy, String name, String qualification, String status) {
        super(id, createdDate, createdBy, updatedDated, updatedBy);
        this.name = name;
        this.qualification = qualification;
        this.status = status;
    }

    public Staff() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
