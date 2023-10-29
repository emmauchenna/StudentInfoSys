package com.kloudvistas;

import com.kloudvistas.dto.StaffDto;
import com.kloudvistas.dto.StudentDto;
import com.kloudvistas.enums.StaffStatus;
import com.kloudvistas.service.StaffService;
import com.kloudvistas.service.StaffServiceImpl;
import com.kloudvistas.service.StudentServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {
        StudentServiceImpl studentService = new StudentServiceImpl();
        StudentDto dto = new StudentDto();

        dto.setDateOfBirth(LocalDate.of(1990, 12, 20));
        dto.setEmail("emmanuel@yahoo.com");
        dto.setFirstName("Emma");
        dto.setLastName("Onwukwe");
        dto.setLevel("100");
        dto.setPassword("12345");
        dto.setPhonenumber("070777777777");

        studentService.saveStudent(dto);


/**
        Student student = new Student();
        student.setId(1);
        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
        studentRepository.saveStudent(student);
 **/

        StaffDto nStaff = new StaffDto() ;
        nStaff.setName("Funmi Funmi");
        nStaff.setQualification("PHD");
        nStaff.setStatus(StaffStatus.INSERVICE.name());

        StaffService d = new StaffServiceImpl();
        d.saveStaff(nStaff);

    }
//POSTMAN
}
