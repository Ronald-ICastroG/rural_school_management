package com.education.rural.persistence.repository.Identity.specialization.teacher;

import com.education.rural.persistence.entity.Identity.specialization.TeacherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaTeacherRepository extends JpaRepository<TeacherEntity, Integer> {


    Page<TeacherEntity> findByTeacherActiveTrue(Pageable pageable);
}
