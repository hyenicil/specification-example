package project.subject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.subject.dto.request.SubjectDtoRequest;
import project.subject.dto.response.SubjectDtoResponse;
import project.subject.entity.Subject;
import project.subject.mapper.SubjectMapper;
import project.subject.service.SubjectService;


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
