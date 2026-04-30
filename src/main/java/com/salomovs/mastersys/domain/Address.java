package com.salomovs.mastersys.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="addresses")
@AllArgsConstructor
@NoArgsConstructor
public class Address {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  Long id;

  private String address;
  private Integer number;
  private String neighborhood;
  private String complement;

  private String city;
  @Column(name="fed_unity")
  private String federalUnity;
  private String zipCode;

  @JsonIgnore
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="student_id")
  private Student student;
}
