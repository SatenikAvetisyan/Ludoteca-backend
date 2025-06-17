package com.ccsw.tutorial.loans.specification;

import com.ccsw.tutorial.common.criteria.SearchCriteria;
import com.ccsw.tutorial.loans.model.Loan;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class LoanSpecification implements Specification<Loan> {
    private SearchCriteria criteria;

    public LoanSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Loan> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Path<?> path;

        if (criteria.getKey().contains(".")) {
            String[] parts = criteria.getKey().split("\\.");
            path = root.join(parts[0]).get(parts[1]);

        } else {
            path = root.get(criteria.getKey());
        }
        switch (criteria.getOperation()) {
        case ":":
            return builder.like(builder.lower(path.as(String.class)), "%" + criteria.getValue().toString().toLowerCase() + "%");

        case "=":
            return builder.equal(path, criteria.getValue());
        default:
            return null;
        }
    }
}
