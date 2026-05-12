package com.salomovs.mastersys.dto.request;

import java.util.Optional;

import com.salomovs.mastersys.domain.Modality;

public record ModalityRequest (
  String name,
  Optional<Boolean> active
) {
  public Modality toEntity() {
    Modality modality = new Modality();
    fillUp(modality);
    return modality;
  }

  public void fillUp(Modality modality) {
    if (active.isPresent())
      modality.setActive(active.get());

    if (name != null)
      modality.setName(name);
  }
}
