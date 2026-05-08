package com.salomovs.mastersys.dto.request;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.salomovs.mastersys.domain.Contact;
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
    Student stu = new Student(null, name, taxId, birthdate, gender, null, null, address.toEntity(), null);
    List<Contact> cMapped = contacts.stream().map((ContactRequest c)->c.toEntity(stu)).collect(Collectors.toList());
    stu.setContacts(cMapped);

    return stu;
  }
}
