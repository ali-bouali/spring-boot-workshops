package com.workshop.bouali.models;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Ali Bouali
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
@Slf4j
public class Employee {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(
      nullable = false,
      unique = true
  )
  private String identifier;

  @Column(nullable = false)
  private String firstname;

  @Column(nullable = false)
  private String lastname;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private LocalDate birthdate;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EmployeeRole role;

  @OneToOne
  @JoinColumn(name = "address_id")
  private Address address;

  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;

  @ManyToMany
  @JoinTable(
      name = "employee_mission",
      joinColumns = @JoinColumn(name = "employee_id"),
      inverseJoinColumns = @JoinColumn(name = "mission_id")
  )
  private List<Mission> missions;

}
