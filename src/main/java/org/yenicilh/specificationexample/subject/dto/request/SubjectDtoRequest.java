package org.yenicilh.specificationexample.subject.dto.request;

import org.yenicilh.specificationexample.student.dto.request.StudentIdDtoRequest;

public record SubjectDtoRequest(
        String name,
        StudentIdDtoRequest student
) {
}
