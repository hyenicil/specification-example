package org.yenicilh.specificationexample.subject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yenicilh.specificationexample.subject.dto.request.SubjectDtoRequest;
import org.yenicilh.specificationexample.subject.dto.response.SubjectDtoResponse;
import org.yenicilh.specificationexample.subject.entity.Subject;
import org.yenicilh.specificationexample.subject.mapper.SubjectMapper;
import org.yenicilh.specificationexample.subject.service.SubjectService;


@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectMapper subjectMapper;

    private final SubjectService subjectService;

    public SubjectController(SubjectMapper subjectMapper, SubjectService subjectService) {
        this.subjectMapper = subjectMapper;
        this.subjectService = subjectService;
    }


    private Subject toEntity(SubjectDtoRequest request) {
        return subjectMapper.toEntity(request);
    }

    private SubjectDtoResponse toResponse(Subject entity) {
        return subjectMapper.toResponse(entity);
    }


}
