package com.education.rural.domain.repository.Identity.specialization;

import com.education.rural.domain.dto.Identity.specialization.staff.StaffDto;
import com.education.rural.domain.dto.Identity.specialization.staff.UpdateStaffDto;

import java.util.List;

public interface StaffRepository {


    List<StaffDto> GetAllStaff();
    StaffDto GetStaffById(int id);
    StaffDto save(StaffDto staffDto);
    StaffDto patch(Integer id, UpdateStaffDto UpdatestaffDto);
    void deleteById(Integer id);
}
