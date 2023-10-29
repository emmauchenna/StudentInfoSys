package com.kloudvistas.repositories;

import com.kloudvistas.database.SQLServerDb;
import com.kloudvistas.domains.Staff;
import com.kloudvistas.enums.StaffStatus;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffRepoImpl implements StaffRepo{

    private final Connection  connection;
    public StaffRepoImpl() {
        SQLServerDb serverDb = new SQLServerDb();
        this.connection = serverDb.getSqlDbConnection();
    }

    @Override
    public void saveStaff(Staff staff) throws SQLException {

        String query = "Insert into staff (Name, Qualification,Status, DateCreated, CreatedBy, DateUpdated, UpdateBy) " +
                " values (?, ?, ?, ?, ? ,? ,? )";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, staff.getName());
        preparedStatement.setString(2,staff.getQualification() );
        preparedStatement.setString(3, staff.getStatus());
        preparedStatement.setTimestamp(4, Timestamp.valueOf(staff.getCreatedDate()) );
        preparedStatement.setString(5, staff.getCreatedBy() );
        preparedStatement.setTimestamp(6, Timestamp.valueOf(staff.getUpdatedDated()) );
        preparedStatement.setString(7, staff.getUpdatedBy());

        int i = preparedStatement.executeUpdate();
        System.out.println("No of record updated: "+i);
    }

    @Override
    public Staff getStaff(int id) {
        Staff staffx = new Staff();
        try {
            String query = "Select name, Qualification,Status, DateCreated, CreatedBy, DateUpdated, UpdateBy" +
                    " from Staff where id = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                staffx.setStatus(resultSet.getString("Status"));
                staffx.setUpdatedBy(resultSet.getString("UpdateBy"));
                staffx.setCreatedBy(resultSet.getString("CreatedBy"));
                staffx.setName(resultSet.getString("Name"));
                staffx.setQualification(resultSet.getString("Qualification"));
                staffx.setCreatedDate(resultSet.getTimestamp("DateCreated").toLocalDateTime());
                staffx.setUpdatedDated(resultSet.getTimestamp("DateUpdated").toLocalDateTime());
            }
        }catch (SQLException ex){
            System.out.println(ex.getSQLState());
            ex.printStackTrace();
        }
        return staffx;
    }

    @Override
    public List<Staff> getStaffs() throws SQLException {
        String query = "Select Name, Qualification,Status, DateCreated, CreatedBy, DateUpdated, UpdateBy from STAFF ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Staff> staffList = new ArrayList<>();
        Staff staff = new Staff();
        while (resultSet.next()){
            staff.setName(resultSet.getString("Name"));
            staff.setQualification(resultSet.getString("Qualification"));
            staff.setStatus(resultSet.getString("Status"));
            staff.setCreatedDate(resultSet.getTimestamp("DateCreated").toLocalDateTime());
            staff.setCreatedBy(resultSet.getString("CreatedBy"));
            staff.setUpdatedBy(resultSet.getString("UpdateBy"));
            staff.setUpdatedDated(resultSet.getTimestamp("DateUpdated").toLocalDateTime());
            staffList.add(staff);
        }
        return staffList;
    }

    @Override
    public void updateState(Staff staffx) throws SQLException {
        String query = "Update staff set name = ?, qualification = ? , dateUpdated = ?  where id = ?  ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, staffx.getName());
        preparedStatement.setString(2, staffx.getQualification());
        preparedStatement.setInt(4, staffx.getId());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

        int d = preparedStatement.executeUpdate();
        System.out.println("No of Item updated: "+ d);
    }

    @Override
    public void DeleteState(int id) {
        String query = "Delete from staff where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            int d = preparedStatement.executeUpdate();
            System.out.println("No of Item updated: " + d);
        }catch (SQLException ex){
            System.out.println(ex.getSQLState());
        }
    }

    @Override
    public void updateQualification(String qualif , int id){

        String sql = "Update staff set qualification = ? where id = ? ";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,qualif);
            preparedStatement.setInt(2, id);

           int d = preparedStatement.executeUpdate();
            System.out.println("No of item Updated: "+ d);
        }catch (SQLException exception){
            System.out.println(exception.getSQLState());
        }
    }
}
