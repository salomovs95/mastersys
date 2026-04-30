package com.salomovs.mastersys.domain;

import java.math.BigDecimal;

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
@Table(name="plans")
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String name;
  private BigDecimal monthlyPrice;
  private Boolean active = true;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="modality_id")
  private Modality modality;
}
