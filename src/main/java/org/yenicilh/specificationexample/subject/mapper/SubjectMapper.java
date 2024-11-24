package org.yenicilh.specificationexample.subject.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.yenicilh.specificationexample.student.mapper.StudentMapper;
import org.yenicilh.specificationexample.subject.entity.Subject;
import org.yenicilh.specificationexample.subject.dto.request.SubjectDtoRequest;
import org.yenicilh.specificationexample.subject.dto.response.SubjectDtoResponse;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = {SubjectMapper.class, StudentMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SubjectMapper {


    //@Mapping(source = "student", target = "student")
    Subject toEntity(SubjectDtoRequest request);

    //@Mapping(source = "student", target = "student")
    SubjectDtoResponse toResponse(Subject entity);

    List<Subject> toEntities(List<SubjectDtoRequest> requests);

}
