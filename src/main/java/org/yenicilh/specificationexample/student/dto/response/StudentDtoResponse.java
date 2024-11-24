package org.yenicilh.specificationexample.student.dto.response;

import org.yenicilh.specificationexample.address.dto.response.AddressDtoResponse;
import org.yenicilh.specificationexample.subject.dto.response.SubjectDtoResponse;

import java.util.Set;

public record StudentDtoResponse(

        Integer id,
        String name,
        AddressDtoResponse address,
        Set<SubjectDtoResponse> subjects

) {
}
