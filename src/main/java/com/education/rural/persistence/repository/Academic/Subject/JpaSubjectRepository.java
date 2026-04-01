package com.education.rural.persistence.repository.Academic.Subject;

import com.education.rural.persistence.entity.Academic.SubjectEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaSubjectRepository extends JpaRepository<SubjectEntity, Integer> {

    SubjectEntity findFirstBySubjectNameIgnoreCase(String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM subject s WHERE s.Sub_Name=:subjectName",nativeQuery = true)
    void deleteBySubjectNameIgnoreCase(@Param("subjectName") String subjectName);
}
