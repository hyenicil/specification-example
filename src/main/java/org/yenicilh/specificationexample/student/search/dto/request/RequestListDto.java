package org.yenicilh.specificationexample.student.search.dto.request;

import org.yenicilh.specificationexample.student.search.enums.SearchOperator;

import java.util.List;

public record RequestListDto(
        List<SearchRequestDto> requestDtoList
) {
}
