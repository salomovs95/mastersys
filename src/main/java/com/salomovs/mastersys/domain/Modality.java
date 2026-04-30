package com.salomovs.mastersys.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="modalities")
@AllArgsConstructor
@NoArgsConstructor
public class Modality {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Boolean active = true;
}
