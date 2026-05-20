package com.salomovs.mastersys.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Optional;

import com.salomovs.mastersys.domain.Registration;
import com.salomovs.mastersys.domain.Student;

public record RegistrationRequest (
  Optional<LocalDate> registrationDate,
  Optional<LocalDate> closingDate,

  @Min(value=1, message="DueDay field must be between 1 and 31")
  @Max(value=31, message="DueDay field must be between 1 and 31")
  @NotNull(message="DueDay field is missinf")
  Integer dueDay,

  RegistrationModalityRequest registrationModality
) {
  public Registration toEntity(Student student) {
    Registration registration = new Registration();
    registration.setStudent(student);
    return registration;
  }

  public void fillUp(Registration registration) {
    if (registrationDate.isPresent())
      registration.setRegistrationDate(registrationDate.get());

    if (closingDate.isPresent())
      registration.setClosingDate(closingDate.get());

    if (dueDay != null)
      registration.setDueDay(dueDay);
  }
}
