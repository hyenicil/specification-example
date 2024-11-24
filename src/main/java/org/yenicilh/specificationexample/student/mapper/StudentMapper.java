package org.yenicilh.specificationexample.student.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.yenicilh.specificationexample.address.mapper.AddressMapper;
import org.yenicilh.specificationexample.student.dto.request.StudentDtoRequest;
import org.yenicilh.specificationexample.student.dto.response.StudentDtoResponse;
import org.yenicilh.specificationexample.student.entity.Student;
import org.yenicilh.specificationexample.subject.mapper.SubjectMapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = {StudentMapper.class, AddressMapper.class, SubjectMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StudentMapper {

    @Mapping(source = "address", target = "address")
    @Mapping(source = "subjects", target = "subjects")
    Student toEntity(StudentDtoRequest request);

    @Mapping(source = "address", target = "address")
    @Mapping(source = "subjects", target = "subjects")
    StudentDtoResponse toResponse(Student entity);

    List<StudentDtoResponse> toResponseList(List<Student> entities);

}
