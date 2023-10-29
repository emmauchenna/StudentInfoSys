package com.kloudvistas.service;

import com.kloudvistas.domains.Staff;
import com.kloudvistas.dto.StaffDto;
import com.kloudvistas.enums.StaffStatus;
import com.kloudvistas.repositories.StaffRepoImpl;
import com.kloudvistas.repositories.StudentRepositoryImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class StaffServiceImpl implements StaffService{

    private final StaffRepoImpl staffRepoImpl;
    private final StudentRepositoryImpl studentRepository;

    public StaffServiceImpl() {

        StaffRepoImpl staffRepoImpl = new StaffRepoImpl();
        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();

        this.staffRepoImpl = staffRepoImpl;
        this.studentRepository= studentRepository;
    }

    @Override
    public void saveStaff(StaffDto staffDto) throws SQLException {
        Staff staff = new Staff();

        //Logic and validation

        staff.setStatus(StaffStatus.INSERVICE.name());
        staff.setName(staffDto.getName());
        staff.setQualification(staffDto.getQualification());
        staff.setCreatedDate(LocalDateTime.now());
        staff.setUpdatedDated(LocalDateTime.now());

        staffRepoImpl.saveStaff(staff);
    }
}
