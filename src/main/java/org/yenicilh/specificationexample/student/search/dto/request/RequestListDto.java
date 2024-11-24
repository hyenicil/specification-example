package org.yenicilh.specificationexample.student.search.dto.request;

import java.util.List;

public record RequestListDto(
        List<SearchRequestDto> requestDtoList
) {
}
