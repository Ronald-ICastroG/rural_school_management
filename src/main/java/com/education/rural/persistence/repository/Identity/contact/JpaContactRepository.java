package com.education.rural.persistence.repository.Identity.contact;

import com.education.rural.domain.dto.Identity.contact.ContactDto;
import com.education.rural.persistence.entity.Identity.ContactEntity;
import jakarta.transaction.Transactional;
import org.hibernate.metamodel.mapping.WhereRestrictable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaContactRepository extends JpaRepository<ContactEntity, Integer> {



    //@Transactional
    //@Query(value="SELECT * FROM contact c WHERE c.con_email = :contactEmail",nativeQuery=true)

    ContactEntity findFirstByContactEmailIgnoreCase(String contactEmail);


    @Modifying
    @Transactional
    @Query(value="DELETE FROM contact c WHERE c.con_email = :contactEmail",nativeQuery=true)
    void deleteByContactEmailIgnoreCase(@Param("contactEmail")String contactEmail);

}
