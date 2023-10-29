package com.kloudvistas.service;


import com.kloudvistas.domains.Student;
import com.kloudvistas.dto.StudentDto;

import java.sql.SQLException;

public interface StudentService {

    void saveStudent(StudentDto studentDto) throws SQLException;

    boolean checkIfExist(String email) throws SQLException;
}

