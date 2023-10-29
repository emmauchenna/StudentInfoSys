package com.kloudvistas.repositories;

import com.kloudvistas.domains.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentRepository {

    //CRUD - Create, retrieve, Update and Delete
    void saveDepartment(Department department) throws SQLException;

    List<Department> getDepartments() throws SQLException;

    Department getDepartmentByName(String DepartmentId) throws SQLException;

    int updateDepartment(String name, String departmentId) throws SQLException;

    int deleteDepartment(String departmentId) throws SQLException;

}
