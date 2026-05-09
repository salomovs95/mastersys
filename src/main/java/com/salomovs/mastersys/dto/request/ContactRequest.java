package com.salomovs.mastersys.dto.request;

import com.salomovs.mastersys.domain.Contact;
import com.salomovs.mastersys.domain.Student;

public record ContactRequest (
  String type,
  String value
) {
  public Contact toEntity(Student student) {
    Contact ct = new Contact();
    ct.setStudent(student);
    return ct;
  }

  public void fillUp(Contact contact) {
    if (type != null)
      contact.setType(type);
    if (value != null)
      contact.setValue(value);
  }
}
