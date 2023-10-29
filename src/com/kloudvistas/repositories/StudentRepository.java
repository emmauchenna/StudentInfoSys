package com.kloudvistas.repositories;

import com.kloudvistas.domains.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository {
    void saveStudent(Student student) throws SQLException;
    Student getStudentById(int id) throws SQLException;
    List<Student> getAllStudent() throws SQLException, ClassNotFoundException;
    List<Student> getStudentByDepartment(String department) throws SQLException;
    int updateStudent(Student student) throws SQLException;
    int deleteStudent(int id) throws SQLException;
    boolean doesStudentExist(String student) throws SQLException;
}
