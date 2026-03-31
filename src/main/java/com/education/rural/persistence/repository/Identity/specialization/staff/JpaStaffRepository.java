package com.education.rural.persistence.repository.Identity.specialization.staff;

import com.education.rural.persistence.entity.Identity.specialization.StaffEntity;
import org.springframework.data.repository.CrudRepository;

public interface JpaStaffRepository extends CrudRepository<StaffEntity,Integer> {
}
