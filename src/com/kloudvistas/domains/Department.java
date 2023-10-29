package com.kloudvistas.domains;

import java.time.LocalDateTime;

public class Department extends Base{

    private String name;
    private String departmentCode;

    public Department(){}
    public Department(int id, LocalDateTime createdDate, String createdBy, LocalDateTime updatedDated, String updatedBy, String name, String departmentCode) {
        super(id, createdDate, createdBy, updatedDated, updatedBy);
        this.name = name;
        this.departmentCode = departmentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
