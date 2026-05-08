package com.salomovs.mastersys.dto.request;

import com.salomovs.mastersys.domain.Contact;
import com.salomovs.mastersys.domain.Student;

public record ContactRequest (
  String type,
  String value
) {
  public Contact toEntity(Student student) {
    Contact ct = new Contact(null, type, value, student);
    return ct;
  }
}
