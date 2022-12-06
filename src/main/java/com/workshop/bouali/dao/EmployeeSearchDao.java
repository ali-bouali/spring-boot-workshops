package com.workshop.bouali.dao;

import com.workshop.bouali.models.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author Ali Bouali
 */
@Repository
@RequiredArgsConstructor
public class EmployeeSearchDao {

  private final EntityManager em;

  public List<Employee> findAllBySimpleQuery(
      String firstname,
      String lastname,
      String email
  ) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

    // select * from employee
    Root<Employee> root = criteriaQuery.from(Employee.class);

    // prepare WHERE clause
    // WHERE firstname like '%ali%'
    Predicate firstnamePredicate = criteriaBuilder
        .like(root.get("firstname"), "%" + firstname + "%");
    Predicate lastnamePredicate = criteriaBuilder
        .like(root.get("lastname"), "%" + lastname + "%");
    Predicate emailPredicate = criteriaBuilder
        .like(root.get("email"), "%" + email + "%");
    Predicate firstnameOrLastnamePredicate = criteriaBuilder.or(
        firstnamePredicate,
        lastnamePredicate
    );
    // => final query ==> select * from employee where firstname like '%ali%'
    // or lastname like '%ali%' and email like '%email%'
    var andEmailPredicate = criteriaBuilder.and(firstnameOrLastnamePredicate, emailPredicate);
    criteriaQuery.where(andEmailPredicate);
    TypedQuery<Employee> query = em.createQuery(criteriaQuery);
    return query.getResultList();
  }


  public List<Employee> findAllByCriteria(
      SearchRequest request
  ) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
    List<Predicate> predicates = new ArrayList<>();

    // select from employee
    Root<Employee> root = criteriaQuery.from(Employee.class);
    if (request.getFirstname() != null) {
      Predicate firstnamePredicate = criteriaBuilder
          .like(root.get("firstname"), "%" + request.getFirstname() + "%");
      predicates.add(firstnamePredicate);
    }

    if (request.getLastname() != null) {
      Predicate lastnamePredicate = criteriaBuilder
          .like(root.get("lastname"), "%" + request.getLastname() + "%");
      predicates.add(lastnamePredicate);
    }

    if (request.getEmail() != null) {
      Predicate emailPredicate = criteriaBuilder
          .like(root.get("email"), "%" + request.getEmail() + "%");
      predicates.add(emailPredicate);
    }

    criteriaQuery.where(
        criteriaBuilder.or(predicates.toArray(new Predicate[0]))
    );

    TypedQuery<Employee> query = em.createQuery(criteriaQuery);
    return query.getResultList();
  }
}
