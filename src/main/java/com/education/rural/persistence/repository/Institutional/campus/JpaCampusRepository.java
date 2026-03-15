package com.education.rural.persistence.repository.Institutional.campus;

import com.education.rural.persistence.entity.Institutional.CampusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCampusRepository extends JpaRepository<CampusEntity, Integer> {

   CampusEntity findFirstByCampusNameIgnoreCase(String campusName);
}
