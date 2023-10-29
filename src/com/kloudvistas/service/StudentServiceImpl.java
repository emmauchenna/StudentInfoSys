package com.kloudvistas.service;

import com.kloudvistas.domains.Student;
import com.kloudvistas.dto.StudentDto;
import com.kloudvistas.repositories.StudentRepositoryImpl;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class StudentServiceImpl implements StudentService{
    private final StudentRepositoryImpl repository;
    public StudentServiceImpl(){
         repository = new StudentRepositoryImpl();
    }


    @Override
    public void saveStudent(StudentDto studentDto) throws SQLException {
        //Validation

        //Does exist
        boolean exist = this.checkIfExist(studentDto.getEmail());
        if(exist){
            System.out.println("Student already exist");
            return;
        }

         //Business logic

       String matricNo = this.getNextMatricNumber();
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setPhonenumber(studentDto.getPhonenumber());
        student.setEmail(studentDto.getEmail());
        student.setDepartmentId(studentDto.getDepartmentId());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setDateRegistered(LocalDateTime.now());
        student.setMatricNo(matricNo);
        student.setStatus(true);
        student.setLevel("100");
        student.setDepartmentId("CSC");
        student.setCreatedDate(LocalDateTime.now());
        student.setCreatedBy("Emma");

        student.setUpdatedDated(LocalDateTime.now());
        student.setUpdatedBy("");
        repository.saveStudent(student);
    }

    @Override
    public boolean checkIfExist(String email) throws SQLException {
        boolean b = repository.doesStudentExist(email);
        return b;
    }

    private String getNextMatricNumber() {
        long dateTime = System.currentTimeMillis();

       // long date = new java.util.Date().getTime();
        return String.valueOf(dateTime);
    }
}



