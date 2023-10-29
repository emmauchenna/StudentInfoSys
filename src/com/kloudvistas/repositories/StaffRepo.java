package com.kloudvistas.repositories;


import com.kloudvistas.domains.Staff;

import java.sql.SQLException;
import java.util.List;

public interface StaffRepo {
    //CRUD
    void saveStaff(Staff staff) throws SQLException;

    Staff getStaff(int id);

    List<Staff> getStaffs() throws SQLException;

    void updateState(Staff staffy) throws SQLException;

    void DeleteState(int id);

    void updateQualification(String qualification, int id) throws SQLException;
}
