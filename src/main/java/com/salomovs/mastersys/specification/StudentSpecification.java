package com.salomovs.mastersys.specification;

import org.springframework.data.jpa.domain.Specification;

import com.salomovs.mastersys.domain.Student;
import com.salomovs.mastersys.dto.filter.StudentFilter;

public class StudentSpecification {
  public static Specification<Student> withFilter(StudentFilter filter) {
    return Specification.where(hasId(filter.id()))
      .or(hasPredicate("name", filter.name()))
      .or(hasPredicate("taxId", filter.taxId()))
      .or(hasPredicate("contact", "email", filter.email()))
      .or(hasPredicate("contact", "mainPhoneNumber", filter.phoneNumber()))
      .or(hasPredicate("contact", "secondNumber", filter.phoneNumber()))
      .or(hasPredicate("gender", filter.gender()))
      .or(hasPredicate("address", "city", filter.city()))
      .or(hasPredicate("address", "federalUnity", filter.state()));
  }

  private static Specification<Student> hasId(Long id) {
    return (root, query, criteria)->(id == null) ? null : criteria.equal(root.get("id"), id);
  }

  private static Specification<Student> hasPredicate(String keyP,String keyS, String predicate) {
    return (root, query, criteria) -> isInvalid(predicate) ? null : criteria.like(
      root.get(keyP).get(keyS),
      "%" + predicate + "%"
    );
  }

  private static Specification<Student> hasPredicate(String key, String predicate) {
    return (root, query, criteria) -> isInvalid(predicate) ? null : criteria.like(
      criteria.lower( root.get(key) ),
      "%" + predicate.toLowerCase() + "%"
    );
  }

  private static Boolean isInvalid(String predicate) {
    return predicate == null || predicate.isBlank();
  }
}
