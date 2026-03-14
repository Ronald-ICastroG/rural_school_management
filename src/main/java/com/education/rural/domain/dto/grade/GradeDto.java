package com.education.rural.domain.dto.grade;

import com.education.rural.persistence.entity.CampusEntity;
import jakarta.persistence.*;

public record GradeDto(

         Integer gradeId,
            String gradeName,
            Boolean gradeActive,

        Integer campusId
) {
}
