package com.salomovs.mastersys.dto.response;

import com.salomovs.mastersys.domain.Contact;

public record ContactResponse (
  String email,
  String mainPhoneNumber,
  String secondPhoneNumber
) {
  public static ContactResponse fromEntity(Contact c) {
    return new ContactResponse(c.getEmail(), c.getMainPhoneNumber(), c.getSecondNumber());
  }
}
