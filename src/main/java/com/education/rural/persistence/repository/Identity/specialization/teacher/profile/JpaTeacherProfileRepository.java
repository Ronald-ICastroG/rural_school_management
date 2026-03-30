package com.education.rural.persistence.repository.Identity.specialization.teacher.profile;


import com.education.rural.persistence.entity.Identity.specialization.TeacherProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTeacherProfileRepository extends JpaRepository<TeacherProfileEntity,Integer> {

    TeacherProfileEntity findFirstByProfileNameIgnoreCase(String name);

}
