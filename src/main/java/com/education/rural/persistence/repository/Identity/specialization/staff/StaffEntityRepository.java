package com.education.rural.persistence.repository.Identity.specialization.staff;

import com.education.rural.domain.dto.Identity.specialization.staff.StaffDto;
import com.education.rural.domain.dto.Identity.specialization.staff.UpdateStaffDto;
import com.education.rural.domain.repository.Identity.specialization.StaffRepository;
import com.education.rural.persistence.entity.Identity.PersonEntity;
import com.education.rural.persistence.entity.Identity.specialization.StaffEntity;
import com.education.rural.persistence.entity.Institutional.CampusEntity;
import com.education.rural.persistence.entity.Institutional.SchoolEntity;
import com.education.rural.persistence.mapper.Identity.specialization.StaffMapper;
import com.education.rural.persistence.repository.Identity.person.JpaPersonRepository;
import com.education.rural.persistence.repository.Institutional.campus.JpaCampusRepository;
import com.education.rural.persistence.repository.Institutional.school.JpaSchoolRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffEntityRepository implements StaffRepository {
    private final StaffMapper staffMapper;
    private final JpaStaffRepository jpaStaffRepository;
    private final JpaSchoolRepository jpaSchoolRepository;
    private final JpaCampusRepository jpaCampusRepository;
    private final JpaPersonRepository jpaPersonRepository;

    public StaffEntityRepository(StaffMapper staffMapper, JpaStaffRepository jpaStaffRepository, JpaSchoolRepository jpaSchoolRepository, JpaCampusRepository jpaCampusRepository, JpaPersonRepository jpaPersonRepository) {
        this.staffMapper = staffMapper;
        this.jpaStaffRepository = jpaStaffRepository;
        this.jpaSchoolRepository = jpaSchoolRepository;
        this.jpaCampusRepository = jpaCampusRepository;
        this.jpaPersonRepository = jpaPersonRepository;
    }


    @Override
    public List<StaffDto> GetAllStaff() {
        return this.staffMapper.StaffsToDto(this.jpaStaffRepository.findAll());
    }

    @Override
    public StaffDto GetStaffById(int id) {
        return this.staffMapper.StaffsToDto(this.jpaStaffRepository.findById(id).orElseThrow(()->new RuntimeException("Staff with id " + id + " not found!")));
    }

    @Override
    public StaffDto save(StaffDto staffDto) {

        SchoolEntity SchoolEntity= this.jpaSchoolRepository.getById(staffDto.escId());
        CampusEntity CampusEntity= this.jpaCampusRepository.getById(staffDto.campusId());
        PersonEntity personEntity= this.jpaPersonRepository.getById(staffDto.personId());
        StaffEntity staffSaved=this.staffMapper.StaffToEntity(staffDto);
        staffSaved.setPersonEntity(personEntity);
        staffSaved.setSchoolEntity(SchoolEntity);
        staffSaved.setCampusEntity(CampusEntity);

        StaffEntity staffResult=this.jpaStaffRepository.save(staffSaved);


        return this.staffMapper.StaffsToDto(staffResult);
    }

    @Override
    public StaffDto patch(Integer id, UpdateStaffDto updateStaffDto) {
        StaffEntity staffEntity=this.jpaStaffRepository
                .findById(id).orElseThrow(()->new RuntimeException("Staff not found"));
        this.staffMapper.updateStaffFromDto(updateStaffDto,staffEntity);
        return this.staffMapper.StaffsToDto(staffEntity);
    }

    @Override
    public void deleteById(Integer id) {
        if(this.jpaStaffRepository.findById(id).isPresent()){
            this.jpaStaffRepository.deleteById(id);
        }

    }
}
