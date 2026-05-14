package com.salomovs.mastersys.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.salomovs.mastersys.domain.Contact;
import com.salomovs.mastersys.domain.Student;

public record ContactRequest (
  @NotBlank(message="Type field is missing")
  @Size(max=8, message="Type field can contain 8 characters at most")
  String type,

  @NotBlank(message="Value field is missing")
  @Size(max=100, message="Value field can contain 100 characters at most")
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
