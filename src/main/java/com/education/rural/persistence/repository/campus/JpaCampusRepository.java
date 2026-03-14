package com.education.rural.persistence.repository.campus;

import com.education.rural.persistence.entity.CampusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCampusRepository extends JpaRepository<CampusEntity, Integer> {

   CampusEntity findFirstByCampusNameIgnoreCase(String campusName);
}
