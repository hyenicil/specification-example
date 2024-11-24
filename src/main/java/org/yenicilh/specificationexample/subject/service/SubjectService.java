package org.yenicilh.specificationexample.subject.service;

import org.springframework.stereotype.Service;
import org.yenicilh.specificationexample.subject.entity.Subject;
import org.yenicilh.specificationexample.subject.repository.SubjectRepository;


@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

}
