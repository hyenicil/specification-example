package project.subject.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import project.subject.entity.Subject;
import project.subject.dto.request.SubjectDtoRequest;
import project.subject.dto.response.SubjectDtoResponse;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = {SubjectMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SubjectMapper {

    Subject toEntity(SubjectDtoRequest request);

    SubjectDtoResponse toResponse(Subject entity);

    List<Subject> toEntities(List<SubjectDtoRequest> requests);
}
