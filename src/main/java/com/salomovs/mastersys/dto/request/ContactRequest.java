package com.salomovs.mastersys.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.salomovs.mastersys.domain.Contact;

public record ContactRequest (
  @NotBlank(message="Email field is missing")
  @Size(max=100, message="Email field can contain 100 characters at most")
  @Email(message="")
  String email,

  @NotBlank(message="MainPhoneNumber field is missing")
  @Size(max=20, message="MainPhoneNumber field can contain 20 characters at most")
  String mainPhoneNumber,

  @NotBlank(message="SecondPhoneMumber field is missing")
  @Size(max=20, message="SecondPhoneNumber field can contain 20 characters at most")
  String secondPhoneNumber
) {
  public Contact toEntity() {
    Contact ct = new Contact();
    fillUp(ct);
    return ct;
  }

  public void fillUp(Contact contact) {
    if (email != null)
      contact.setEmail(email);
    if (mainPhoneNumber != null)
      contact.setMainPhoneNumber(mainPhoneNumber);
    if (secondPhoneNumber != null)
      contact.setSecondNumber(secondPhoneNumber);
  }
}
