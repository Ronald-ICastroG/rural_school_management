package com.education.rural.persistence.repository.Identity.specialization.student;

import com.education.rural.persistence.entity.Identity.specialization.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStudentRepository extends JpaRepository<StudentEntity,Integer> {
}
