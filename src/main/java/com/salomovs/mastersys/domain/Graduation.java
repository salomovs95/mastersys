package com.salomovs.mastersys.domain;

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
@Table(name="graduations")
@AllArgsConstructor
@NoArgsConstructor
public class Graduation {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="modality_id")
  private Modality modality;
}
