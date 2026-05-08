package com.salomovs.mastersys.dto.response;

import com.salomovs.mastersys.domain.Contact;

public record ContactResponse (
  Long id,
  String type,
  String value
) {
  public static ContactResponse fromEntity(Contact c) {
    return new ContactResponse(c.getId(), c.getType(), c.getValue());
  }
}
