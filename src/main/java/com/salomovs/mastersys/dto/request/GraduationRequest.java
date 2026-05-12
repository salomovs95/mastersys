package com.salomovs.mastersys.dto.request;

import com.salomovs.mastersys.domain.Graduation;
import com.salomovs.mastersys.domain.Modality;

public record GraduationRequest (
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
