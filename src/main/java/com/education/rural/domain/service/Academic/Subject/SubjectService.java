package com.education.rural.domain.service.Academic.Subject;

import com.education.rural.domain.dto.Academic.subject.SubjectDto;
import com.education.rural.domain.dto.Academic.subject.UpdateSubjectDto;
import com.education.rural.domain.repository.Academic.Subject.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<SubjectDto> findAllSubjects() {
        return this.subjectRepository.findAll();
    }

    @Override
    public SubjectDto findSubjectById(Integer id) {
        return this.subjectRepository.findById(id);
    }

    @Override
    public SubjectDto findFirstBySubjectNameIgnoreCase(String subjectName) {
        return this.subjectRepository.findFirstBySubjectNameIgnoreCase(subjectName);
    }

    @Override
    public SubjectDto saveSubject(SubjectDto subjectDto) {
        return this.subjectRepository.save(subjectDto);
    }

    @Override
    public SubjectDto patchSubject(Integer id, UpdateSubjectDto updateSubjectDto) {
        return this.subjectRepository.patch(id, updateSubjectDto);
    }

    @Override
    public void deleteSubjectById(Integer id) {
        this.subjectRepository.deleteById(id);
        System.out.println("Deleted subject with id " + id);
    }

    @Override
    public void deleteBySubjectNameIgnoreCase(String subjectName) {
        this.subjectRepository.deleteByName(subjectName);
        System.out.println("Deleted subject with name " + subjectName);
    }
}
