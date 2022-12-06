package com.workshop.bouali.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ali Bouali
 */
@Setter
@Getter
@Entity
public class Address {

  @Id
  @GeneratedValue
  private Integer id;

  private String streetName;

  private String houseNumber;

  private String zipCode;

  // @OneToOne
  // @JoinColumn(name = "employee_id")
  // private Employee employee;

}
