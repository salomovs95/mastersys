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
@Table(name="contacts")
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name="ctype")
  private String type;

  @Column(name="cvalue")
  private String value;

  @JsonIgnore
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="student_id")
  private Student student;
}
