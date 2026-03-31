package com.education.rural.domain.service.Identity.specialization.staff;

import com.education.rural.domain.dto.Identity.specialization.staff.StaffDto;
import com.education.rural.domain.dto.Identity.specialization.staff.UpdateStaffDto;

import java.util.List;

public interface IStaffService {

    List<StaffDto> findAll();
    StaffDto findById(Integer id);
    StaffDto save(StaffDto staffDto);
    StaffDto patch(Integer id, UpdateStaffDto updateStaffDto);
    void deleteById(Integer id);
}
