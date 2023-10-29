package com.kloudvistas.service;

import com.kloudvistas.dto.StaffDto;

import java.sql.SQLException;

public interface StaffService {
    void saveStaff(StaffDto staffDto) throws SQLException;
}
