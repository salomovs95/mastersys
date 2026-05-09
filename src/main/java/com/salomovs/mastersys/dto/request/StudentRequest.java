package com.salomovs.mastersys.dto.request;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.salomovs.mastersys.domain.Student;

public record StudentRequest (
  String name,
  String taxId,
  LocalDate birthdate,
  String gender,
  List<ContactRequest> contacts,
  AddressRequest address
) {
  public Student toEntity() {
    Student student = new Student();
    fillUp(student);
    return student;
  }

  public void fillUp(Student student) {
    if (name != null)
      student.setName(name);

    if (taxId != null)
      student.setTaxId(taxId);

    if (birthdate != null)
      student.setBirthdate(birthdate);

    if (gender != null)
      student.setGender(gender);

    if (address != null)
      student.setAddress(address.toEntity());

    if (contacts != null) student.setContacts(contacts
      .stream()
      .map((ContactRequest c)->c.toEntity(student))
      .collect(Collectors.toList())
    );
  }
}
