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
public class Contact {
  private String email;
  private String mainPhoneNumber;
  private String secondNumber;
}
