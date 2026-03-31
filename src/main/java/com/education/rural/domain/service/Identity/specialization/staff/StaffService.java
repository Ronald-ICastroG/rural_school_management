package com.education.rural.domain.service.Identity.specialization.staff;

import com.education.rural.domain.dto.Identity.specialization.staff.StaffDto;
import com.education.rural.domain.dto.Identity.specialization.staff.UpdateStaffDto;
import com.education.rural.domain.repository.Identity.specialization.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService implements IStaffService{
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<StaffDto> findAll() {
        return this.staffRepository.GetAllStaff();
    }

    @Override
    public StaffDto findById(Integer id) {
        return this.staffRepository.GetStaffById(id);
    }

    @Override
    public StaffDto save(StaffDto staffDto) {
        return this.staffRepository.save(staffDto);
    }

    @Override
    public StaffDto patch(Integer id, UpdateStaffDto updateStaffDto) {
        return this.staffRepository.patch(id, updateStaffDto);
    }

    @Override
    public void deleteById(Integer id) {
    this.staffRepository.deleteById(id);
        System.out.println("Member of staff with id: " + id + " has been deleted");
    }
}
