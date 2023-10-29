package com.kloudvistas.repositories;

import com.kloudvistas.database.SQLServerDb;
import com.kloudvistas.domains.Student;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private   Connection connection ;

    public StudentRepositoryImpl(){
        SQLServerDb serverDb = new SQLServerDb();
        connection =  serverDb.getSqlDbConnection();
    }
//DOMAIN or ENTITY


    //CRUD - Create (save/post), Retrieve (get), update(change/put), delete (remove)

    // Create, update and delete - executeUpdate();
    // Retrieve (get) - executeQuery();
    @Override
    public void saveStudent(Student student) throws SQLException {

        String query = " Insert into Student ( FirstName, LastName, DateOfBirth, Email, Phone, MatricNo, Password, Status, AcademicLevel,\n" +
                "  DepartmentId, DateRegistered, CreatedBy, DateCreated, UpdateBy, DateUpdated) values (?, ?, ?, ?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ? )";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        LocalDate dateOfBirth = student.getDateOfBirth();


        preparedStatement.setDate(3,   Date.valueOf(dateOfBirth));
        preparedStatement.setString(4, student.getEmail());
        preparedStatement.setString(5, student.getPhonenumber());
        preparedStatement.setString(6, student.getMatricNo());
        preparedStatement.setString(7, student.getPassword());
        preparedStatement.setBoolean(8, student.isStatus());
        preparedStatement.setString(9, student.getLevel());
        preparedStatement.setString(10, student.getDepartmentId());
        preparedStatement.setTimestamp(11, Timestamp.valueOf(student.getDateRegistered()));
        preparedStatement.setString(12, student.getCreatedBy());
        preparedStatement.setTimestamp(13, Timestamp.valueOf(student.getCreatedDate()));
        preparedStatement.setString(14, student.getUpdatedBy());
        preparedStatement.setTimestamp(15, Timestamp.valueOf(student.getUpdatedDated()));

        preparedStatement.executeUpdate();
    }

    @Override
    public Student getStudentById(int id) throws SQLException {
        String query = "select FirstName, LastName, DateOfBirth, Email, Phone, MatricNo, Password, Status, AcademicLevel," +
                " DepartmentId, DateRegistered, CreatedBy, DateCreated, UpdateBy, DateUpdated from Student where id = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Student student = new Student();

        while (resultSet.next()){

            student.setFirstName(resultSet.getString("FirstName"));
            student.setLastName(resultSet.getString("LastName"));
            student.setDateOfBirth(resultSet.getDate("DateOfBirth").toLocalDate());
            student.setMatricNo(resultSet.getString("MatricNo"));
            student.setPassword(resultSet.getString("Password"));
            student.setEmail(resultSet.getString("Email"));
            student.setDepartmentId(resultSet.getString("DepartmentId"));
            student.setPhonenumber(resultSet.getString("Phone"));
            student.setStatus(resultSet.getBoolean("Stutus"));
            student.setDateRegistered(resultSet.getTimestamp("DateRegistered").toLocalDateTime());
            student.setCreatedDate(resultSet.getTimestamp("DateCreated").toLocalDateTime());
            student.setCreatedBy(resultSet.getString("CreatedBy"));
            student.setUpdatedBy(resultSet.getString("UpdateBy"));
            student.setLevel(resultSet.getString("AcademicLevel"));
        }

        return student;
    }

    @Override
    public List<Student> getAllStudent() throws SQLException, ClassNotFoundException {
        String query = "select FirstName, LastName, DateOfBirth, Email, Phone, MatricNo, Password, Status, AcademicLevel," +
                "DepartmentId, DateRegistered, CreatedBy, DateCreated, UpdateBy, DateUpdated from Student";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        while (resultSet.next()){

            student.setFirstName(resultSet.getString("FirstName"));
            student.setLastName(resultSet.getString("LastName"));
            student.setDateOfBirth(resultSet.getDate("DateOfBirth").toLocalDate());
            student.setMatricNo(resultSet.getString("MatricNo"));
            student.setPassword(resultSet.getString("Password"));
            student.setEmail(resultSet.getString("Email"));
            student.setDepartmentId(resultSet.getString("DepartmentId"));
            student.setPhonenumber(resultSet.getString("Phone"));
            student.setStatus(resultSet.getBoolean("Stutus"));
            student.setDateRegistered(resultSet.getTimestamp("DateRegistered").toLocalDateTime());
            student.setCreatedDate(resultSet.getTimestamp("DateCreated").toLocalDateTime());
            student.setCreatedBy(resultSet.getString("CreatedBy"));
            student.setUpdatedBy(resultSet.getString("UpdateBy"));
            student.setLevel(resultSet.getString("AcademicLevel"));

            studentList.add(student);

        }
        return studentList;
    }

    @Override
    public List<Student> getStudentByDepartment(String departmentId) throws SQLException {
        String query = "select FirstName, LastName, DateOfBirth, Email, Phone, MatricNo, Password, Status, AcademicLevel," +
                "DepartmentId, DateRegistered, CreatedBy, DateCreated, UpdateBy, DateUpdated from Student" +
                "where departmentId = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,departmentId);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        while (resultSet.next()){

            student.setFirstName(resultSet.getString("FirstName"));
            student.setLastName(resultSet.getString("LastName"));
            student.setDateOfBirth(resultSet.getDate("DateOfBirth").toLocalDate());
            student.setMatricNo(resultSet.getString("MatricNo"));
            student.setPassword(resultSet.getString("Password"));
            student.setEmail(resultSet.getString("Email"));
            student.setDepartmentId(resultSet.getString("DepartmentId"));
            student.setPhonenumber(resultSet.getString("Phone"));
            student.setStatus(resultSet.getBoolean("Stutus"));
            student.setDateRegistered(resultSet.getTimestamp("DateRegistered").toLocalDateTime());
            student.setCreatedDate(resultSet.getTimestamp("DateCreated").toLocalDateTime());
            student.setCreatedBy(resultSet.getString("CreatedBy"));
            student.setUpdatedBy(resultSet.getString("UpdateBy"));
            student.setLevel(resultSet.getString("AcademicLevel"));

            studentList.add(student);

        }
        return studentList;
    }

    @Override
    public int updateStudent(Student student) throws SQLException {

        String query = "Update Student set firstname = ?, lastname = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        preparedStatement.setInt(3, student.getId());

        return preparedStatement.executeUpdate();
    }

    @Override
    public int deleteStudent(int id) throws SQLException {
        String query = "Delete from Student Where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        int i = preparedStatement.executeUpdate();
        return i;
    }

    @Override
    public boolean doesStudentExist(String email) throws SQLException {
        String query = "select count(*) from Student where email = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,email);
        int updateCount = preparedStatement.getUpdateCount();

        //ResultSet resultSet = preparedStatement.executeQuery();
       // boolean first = resultSet.first();
        if(updateCount> 0) return true;
        return false;
    }

}
