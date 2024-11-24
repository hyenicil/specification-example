package org.yenicilh.specificationexample.student.dto.request;

import org.yenicilh.specificationexample.address.dto.request.AddressIdDtoRequest;
import org.yenicilh.specificationexample.subject.dto.request.SubjectIdDtoRequest;

import java.util.Set;

public record StudentDtoRequest(
        String name,
        AddressIdDtoRequest address,
        Set<SubjectIdDtoRequest> subjects
) {
}
