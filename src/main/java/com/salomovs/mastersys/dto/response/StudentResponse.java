package com.salomovs.mastersys.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.salomovs.mastersys.domain.Student;

public record StudentResponse (
  Long id,
  String name,
  String taxId,
  LocalDate birthdate,
  String gender,
  LocalDateTime registeredAt,
  AddressResponse address,
  ContactResponse contact
) {
  public static StudentResponse fromEntity(Student s) {
    return new StudentResponse(
      s.getId(),
      s.getName(),
      s.getTaxId(),
      s.getBirthdate(),
      s.getGender(),
      s.getRegisteredAt(),
      AddressResponse.fromEntity(s.getAddress()),
      ContactResponse.fromEntity(s.getContact())
    );
  }
}
