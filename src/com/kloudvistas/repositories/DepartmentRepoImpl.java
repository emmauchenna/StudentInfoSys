package com.kloudvistas.repositories;

import com.kloudvistas.database.SQLServerDb;
import com.kloudvistas.domains.Department;
import com.kloudvistas.repositories.DepartmentRepository;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepoImpl implements DepartmentRepository {

    private Connection connection;

    public DepartmentRepoImpl() {
        SQLServerDb db = new SQLServerDb();
        this.connection = db.getSqlDbConnection();
    }

    //save, Delete, update - executeUpdate(Query);
    //select - executeQuery(query);

    @Override
    public void saveDepartment(Department department) throws SQLException {

        String query = " Insert into Department ( id, Name, DepartmentId, CreatedBy, DateCreated, UpdateBy, DateUpdated) values (?,?, ?, ?,?, ?, ? )";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,department.getId());
            preparedStatement.setString(2,department.getName());
            preparedStatement.setString(3,department.getDepartmentCode());
            preparedStatement.setString(4,department.getCreatedBy());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(department.getCreatedDate()));
            preparedStatement.setString(6,department.getUpdatedBy());
            preparedStatement.setTimestamp(7,Timestamp.valueOf(department.getUpdatedDated()));
            int v = preparedStatement.executeUpdate();
            System.out.println("The number row createed: "+ v);
        } finally {
            connection.close();
        }
    }

    @Override
    public List<Department> getDepartments() throws SQLException {

        String query = "Select * from department";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<Department> departmentList = new ArrayList<>();
        while(resultSet.next()){
            Department department = new Department();
            department.setId(resultSet.getInt("id"));
            department.setName(resultSet.getString("name"));
            department.setDepartmentCode(resultSet.getString("DepartmentId"));
            department.setUpdatedBy(null);
            //  Date date = resultSet.getDate("UpdatedBy");
            // department.setUpdatedDated(new java.sql.Date(date.getTime()).toLocalDate().atStartOfDay());
            department.setUpdatedDated(new java.sql.Timestamp(resultSet.getDate("UpdatedBy")
                    .getTime())
                    .toLocalDateTime());

            department.setCreatedDate(LocalDateTime.now());
            department.setCreatedBy(resultSet.getString("UpdatedBy"));

            departmentList.add(department);
            department = null;
        }
        return departmentList;
    }

    @Override
    public Department getDepartmentByName(String departmentId) throws SQLException {

        String query = "select * from department where departmentId = ? ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, departmentId);
        ResultSet resultSet = statement.executeQuery();

        Department department = new Department();
        while(resultSet.next()){

            department.setId(resultSet.getInt("id"));
            department.setName(resultSet.getString("name"));
            department.setDepartmentCode(resultSet.getString("DepartmentId"));
            department.setUpdatedBy(null);
          //  Date date = resultSet.getDate("UpdatedBy");
           // department.setUpdatedDated(new java.sql.Date(date.getTime()).toLocalDate().atStartOfDay());
            department.setUpdatedDated(new java.sql.Timestamp(resultSet.getDate("UpdatedBy")
                    .getTime())
                    .toLocalDateTime());

            department.setCreatedDate(LocalDateTime.now());
            department.setCreatedBy(resultSet.getString("UpdatedBy"));
        }

        return department;
    }

    @Override
    public int updateDepartment(String name, String departmentId) throws SQLException {

        String query = "Update Department set name = ? where departmentId = ? ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,name);
        statement.setString(2,departmentId);
        int i = statement.executeUpdate(query);
        return i;
    }

    @Override
    public int deleteDepartment(String departmentId) throws SQLException {
        String query = "delete from Department where departmentId = ? ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,departmentId);
        int i = statement.executeUpdate(query);

        return i;
    }
}
