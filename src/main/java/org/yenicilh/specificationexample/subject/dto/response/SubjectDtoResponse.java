package org.yenicilh.specificationexample.subject.dto.response;

import org.yenicilh.specificationexample.student.dto.request.StudentDtoRequest;
import org.yenicilh.specificationexample.student.dto.response.StudentDtoResponse;

public record SubjectDtoResponse(
        Integer id,
        String name) {
}
