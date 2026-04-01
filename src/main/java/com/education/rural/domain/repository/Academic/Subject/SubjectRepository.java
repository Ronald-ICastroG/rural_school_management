package com.education.rural.domain.repository.Academic.Subject;

import com.education.rural.domain.dto.Academic.subject.SubjectDto;
import com.education.rural.domain.dto.Academic.subject.UpdateSubjectDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectRepository {


    List<SubjectDto> findAll();
    SubjectDto findById(Integer id);
    SubjectDto findFirstBySubjectNameIgnoreCase(String subjectName);
    SubjectDto save(SubjectDto subjectDto);
    SubjectDto patch(Integer id, UpdateSubjectDto updateSubjectDto);
    void deleteById(Integer id);
    void deleteByName(String name);
}
