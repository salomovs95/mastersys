package com.salomovs.mastersys.domain;


import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {
  private String address;
  private String number;
  private String neighborhood;
  private String complement;
  private String city;
  private String federalUnity;
  private String zipCode;
}
