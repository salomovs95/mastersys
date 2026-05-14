package com.salomovs.mastersys.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import com.salomovs.mastersys.domain.Graduation;
import com.salomovs.mastersys.domain.Modality;

public record GraduationRequest (
  @NotEmpty(message="Name field is missing")
  @Size(min=100, message="Name field can contain 100 characters at most")
  String name
) {
  public Graduation toEntity(Modality modality) {
    Graduation graduation = new Graduation();
    graduation.setModality(modality);
    fillUp(graduation);
    return graduation;
  }

  public void fillUp(Graduation graduation) {
    if (name != null)
      graduation.setName(name);
  }
}
