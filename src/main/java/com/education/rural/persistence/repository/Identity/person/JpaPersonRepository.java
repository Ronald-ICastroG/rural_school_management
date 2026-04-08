package com.education.rural.persistence.repository.Identity.person;

import com.education.rural.persistence.entity.Identity.PersonEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaPersonRepository extends JpaRepository<PersonEntity, Integer> {


    PersonEntity findFirstByFirstNameIgnoreCase(String firstName);

    //@Transactional
    //@Param("personDni")
    //@Query(value = "SELECT * FROM person p WHERE p.Person_Dni=:personDni",nativeQuery = true)
    PersonEntity findFirstByPersonDniIgnoreCase(String personDni);

    @Modifying
    @Transactional
    @Query(value = "DELETE from person p WHERE p.per_dni=:personDni",nativeQuery = true)
    void deleteByPersonDni(@Param("personDni")String personDni);


}
