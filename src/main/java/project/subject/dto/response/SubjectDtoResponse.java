package project.subject.dto.response;

import project.student.dto.request.StudentDtoRequest;

public record SubjectDtoResponse(
        Integer id,
        String name,
        StudentDtoRequest student
) {
}
