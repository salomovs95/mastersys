package com.salomovs.mastersys.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

import com.salomovs.mastersys.domain.Student;

public record StudentRequest (
  @NotBlank(message="Name field is missing")
  @Size(max=150, message="Name field can contain 100 characters at most")
  String name,

  @NotBlank(message="TaxId field is missing")
  @Size(max=30, message="TaxId field can contain 30 characters at most")
  String taxId,

  @NotNull(message="Birthdate field is missing")
  @Past(message="Only past birthdate values are allowed")
  LocalDate birthdate,

  @NotBlank(message="Gender field is missing")
  @Size(max=1, message="Gender field can contain 1 character at most")
  String gender,

  ContactRequest contact,

  @NotNull(message="Address field iss missing")
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

    if (contact != null)
        student.setContact(contact.toEntity());
  }
}
