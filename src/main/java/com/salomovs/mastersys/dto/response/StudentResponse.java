package com.salomovs.mastersys.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.salomovs.mastersys.domain.Student;

public record StudentResponse (
  Long id,
  String name,
  String taxId,
  LocalDate birthdate,
  String gender,
  LocalDateTime registeredAt,
  List<ContactResponse> contacts,
  List<AddressResponse> addresses
) {
  public static StudentResponse fromEntity(Student s) {
    return new StudentResponse(
      s.getId(),
      s.getName(),
      s.getTaxId(),
      s.getBirthdate(),
      s.getGender(),
      s.getRegisteredAt(),
      s.getContacts().stream().map(c->ContactResponse.fromEntity(c)).collect(Collectors.toList()),
      s.getAddresses().stream().map(a->AddressResponse.fromEntity(a)).collect(Collectors.toList())
    );
  }
}
