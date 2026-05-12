package com.salomovs.mastersys.dto.response;

import java.time.LocalDate;

import com.salomovs.mastersys.domain.Registration;
import com.salomovs.mastersys.domain.enums.RegistrationStatus;

public record RegistrationResponse (
  Long id,
  LocalDate registrationDate,
  LocalDate closingDate,
  Integer dueDay,
  RegistrationStatus status,
  StudentResponse student
) {
  public static RegistrationResponse fromEntity(Registration registration) {
    return new RegistrationResponse(
      registration.getId(),
      registration.getRegistrationDate(),
      registration.getClosingDate(),
      registration.getDueDay(),
      registration.getStatus(),
      StudentResponse.fromEntity(registration.getStudent())
    );
  }
}
