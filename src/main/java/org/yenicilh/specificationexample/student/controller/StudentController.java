package org.yenicilh.specificationexample.student.controller;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import org.yenicilh.specificationexample.student.dto.request.StudentDtoRequest;
import org.yenicilh.specificationexample.student.dto.response.StudentDtoResponse;
import org.yenicilh.specificationexample.student.entity.Student;
import org.yenicilh.specificationexample.student.mapper.StudentMapper;
import org.yenicilh.specificationexample.student.search.dto.request.RequestDto;
import org.yenicilh.specificationexample.student.search.dto.request.RequestListDto;
import org.yenicilh.specificationexample.student.service.StudentService;
import org.yenicilh.specificationexample.student.specification.StudentSpecification;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;

    private final StudentMapper studentMapper;

    private final StudentSpecification studentSpecification;

    public StudentController(StudentService studentService, StudentMapper studentMapper, StudentSpecification studentSpecification) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
        this.studentSpecification = studentSpecification;
    }


    @GetMapping("/student/{name}")
    public StudentDtoResponse getNameForStudent(@PathVariable String name) {
        return toResponse(studentService.getNameForStudent(name));
    }

    @GetMapping("/subject/{subject}")
    public List<StudentDtoResponse> getNameForSubject(@PathVariable String subject) {
        List<Student> list = studentService.getNameForSubject(subject);
        return studentMapper.toResponseList(list);
    }

    @PostMapping("/filter")
    public List<StudentDtoResponse> filter(@RequestBody RequestDto request) {
        Specification<Student> specification = studentSpecification.getSpecificationEqual(request.request());
        return studentMapper.toResponseList(studentService.findAll(specification));
    }

    @PostMapping("/filterList1")
    public List<StudentDtoResponse> filterList1(@RequestBody RequestListDto request) {
        Specification<Student> specification = studentSpecification.getSpecificationAnd(request.requestDtoList());
        return studentMapper.toResponseList(studentService.findAll(specification));
    }

    @PostMapping("/filterList2")
    public List<StudentDtoResponse> filterList2(@RequestBody RequestListDto request) {
        Specification<Student> specification = studentSpecification.getSpecificationAndOr(request.requestDtoList());
        return studentMapper.toResponseList(studentService.findAll(specification));
    }

    @PostMapping("/filterOperators")
    public List<StudentDtoResponse> filterOperators(@RequestBody RequestListDto request) {
        Specification<Student> specification = studentSpecification.getSpecificationOperators(request.requestDtoList());
        return studentMapper.toResponseList(studentService.findAll(specification));
    }


    private Student toEntity(StudentDtoRequest request) {
      return  studentMapper.toEntity(request);
    }

    private StudentDtoResponse toResponse(Student entity) {
        return studentMapper.toResponse(entity);
    }
}
