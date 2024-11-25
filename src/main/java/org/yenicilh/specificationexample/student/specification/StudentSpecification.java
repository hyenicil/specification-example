package org.yenicilh.specificationexample.student.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.yenicilh.specificationexample.student.search.dto.request.SearchRequestDto;
import org.yenicilh.specificationexample.student.search.enums.SearchOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class StudentSpecification<T> {

    public Specification<T> getSpecificationEqual(SearchRequestDto request) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(request.column()), request.value());
            }
        };
    }

    public Specification<T> getSpecificationAnd(List<SearchRequestDto> requests) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            for(SearchRequestDto request : requests) {
                predicates.add(criteriaBuilder.equal(root.get(request.column()), request.value()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };

    }

    public Specification<T> getSpecificationAndOr(List<SearchRequestDto> requests) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            for(SearchRequestDto dto: requests) {
               predicates.add(criteriaBuilder.equal(root.get(dto.column()), dto.value()));


            if(dto.operator().equals(SearchOperator.AND)) {
                predicates.add(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            }

            else{
                predicates.add(criteriaBuilder.or(predicates.toArray(new Predicate[0])));
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }

    public Specification<T> getSpecificationOperators(List<SearchRequestDto> requests) {
        return(root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            for(SearchRequestDto dto: requests) {
                switch (dto.operator()) {

                    case LIKE:
                        Predicate like =  criteriaBuilder.like(root.get(dto.column()),"%" + dto.value() + "%");
                        predicates.add(like);
                        break;
                    case EQUAL:
                        Predicate equal =  criteriaBuilder.equal(root.get(dto.column()), dto.value());
                        predicates.add(equal);
                        break;
                    case IN:
                        String[] splitVal = dto.value().split(",");
                        Predicate in = root.get(dto.column()).in(Arrays.asList(splitVal));
                        predicates.add(in);
                        break;
                    case LESS_THAN:
                        Predicate lessThan =  criteriaBuilder.lessThan(root.get(dto.column()), dto.value());
                        predicates.add(lessThan);
                        break;
                    case GREATER_THAN:
                        Predicate greaterThan =  criteriaBuilder.greaterThan(root.get(dto.column()), dto.value());
                        predicates.add(greaterThan);
                        break;
                    case BETWEEN:
                        String[] betweenVal = dto.value().split(",");
                        Predicate between =  criteriaBuilder.between(root.get(dto.column()), betweenVal[0], betweenVal[1]);
                        predicates.add(between);
                        break;
                    case JOIN:
                        Predicate join = criteriaBuilder.equal(root.join(dto.joinTable()).get(dto.column()), dto.value());
                        predicates.add(join);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + dto.operator());
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };


    }
}
