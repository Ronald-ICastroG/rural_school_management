package com.education.rural.domain.service.Academic.Subject;

import com.education.rural.domain.dto.Academic.subject.SubjectDto;
import com.education.rural.domain.dto.Academic.subject.UpdateSubjectDto;

import java.util.List;

public interface ISubjectService {


    List<SubjectDto> findAllSubjects();
    SubjectDto findSubjectById(Integer id);
    SubjectDto findFirstBySubjectNameIgnoreCase(String subjectName);
    SubjectDto saveSubject(SubjectDto subjectDto);
    SubjectDto patchSubject(Integer id,UpdateSubjectDto updateSubjectDto);
    void deleteSubjectById(Integer id);
    void deleteBySubjectNameIgnoreCase(String subjectName);
}
