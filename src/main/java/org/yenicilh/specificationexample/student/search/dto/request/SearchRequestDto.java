package org.yenicilh.specificationexample.student.search.dto.request;

import org.yenicilh.specificationexample.student.search.enums.SearchOperator;

public record SearchRequestDto(
        String column,
        String value,
        SearchOperator operator,
        String joinTable
) {
}
