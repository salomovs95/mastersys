package com.salomovs.mastersys.dto.request;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.salomovs.mastersys.domain.Address;
import com.salomovs.mastersys.domain.Contact;
import com.salomovs.mastersys.domain.Student;

public record StudentRequest (
  String name,
  String taxId,
  LocalDate birthdate,
  String gender,
  List<ContactRequest> contacts,
  List<AddressRequest> addresses
) {
  public Student toEntity() {
    Student stu = new Student(null, name, taxId, birthdate, gender, null, null, null, null);
    List<Contact> cMapped = contacts.stream().map((ContactRequest c)->c.toEntity(stu)).collect(Collectors.toList());
    List<Address> aMapped = addresses.stream().map((AddressRequest a)->a.toEntity(stu)).collect(Collectors.toList());

    stu.setAddresses(aMapped);
    stu.setContacts(cMapped);

    return stu;
  }
}
