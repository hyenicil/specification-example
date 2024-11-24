package org.yenicilh.specificationexample.student.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.yenicilh.specificationexample.student.search.dto.request.SearchRequestDto;

import java.util.ArrayList;
import java.util.List;


@Component
public class StudentSpecification<T> {

    public Specification<T> getSpecification(SearchRequestDto request) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(request.column()), request.value());
            }
        };
    }

    public Specification<T> getSpecification(List<SearchRequestDto> requests) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            for(SearchRequestDto request : requests) {
                predicates.add(criteriaBuilder.equal(root.get(request.column()), request.value()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };

    }
}
