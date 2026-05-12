package com.salomovs.mastersys.dto.request;

import java.time.LocalDate;
import java.util.Optional;

import com.salomovs.mastersys.domain.Registration;
import com.salomovs.mastersys.domain.Student;

public record RegistrationRequest (
  Optional<LocalDate> registrationDate,
  Optional<LocalDate> closingDate,
  Integer dueDay
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
