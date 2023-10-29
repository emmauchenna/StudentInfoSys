package com.kloudvistas.domains;

import java.time.LocalDateTime;

public class Base {
    private int id;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime updatedDated;
    private String updatedBy;

    public Base(){}

    public Base(int id, LocalDateTime createdDate, String createdBy, LocalDateTime updatedDated, String updatedBy) {
        this.id = id;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDated = updatedDated;
        this.updatedBy = updatedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedDated() {
        return updatedDated;
    }

    public void setUpdatedDated(LocalDateTime updatedDated) {
        this.updatedDated = updatedDated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
