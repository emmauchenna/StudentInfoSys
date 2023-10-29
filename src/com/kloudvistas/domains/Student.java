package com.kloudvistas.domains;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student extends Base{

    private String firstName;
    private String lastName;
    private String matricNo;
    private String password;
    private String phonenumber;
    private String email;
    private boolean status;
    private LocalDate dateOfBirth;
    private LocalDateTime DateRegistered;
    private String level;
    private String departmentId;
    private String entryMode;

    public Student(){}


    public Student(int id, LocalDateTime createdDate, String createdBy, LocalDateTime updatedDated, String updatedBy, String firstName, String lastName, String matricNo, String password, String phonenumber, String email, boolean status, LocalDate dateOfBirth, LocalDateTime dateRegistered, String level, String departmentId) {
        super(id, createdDate, createdBy, updatedDated, updatedBy);
        this.firstName = firstName;
        this.lastName = lastName;
        this.matricNo = matricNo;
        this.password = password;
        this.phonenumber = phonenumber;
        this.email = email;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        DateRegistered = dateRegistered;
        this.level = level;
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMatricNo() {
        return matricNo;
    }

    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getDateRegistered() {
        return DateRegistered;
    }

    public void setDateRegistered(LocalDateTime dateRegistered) {
        DateRegistered = dateRegistered;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getEntryMode() {
        return entryMode;
    }

    public void setEntryMode(String entryMode) {
        this.entryMode = entryMode;
    }
}
