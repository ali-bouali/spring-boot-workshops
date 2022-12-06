package com.workshop.bouali.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ali Bouali
 */
@Getter
@Setter
@Entity
public class Department {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  @OneToMany(mappedBy = "department")
  private List<Employee> employees;
}
