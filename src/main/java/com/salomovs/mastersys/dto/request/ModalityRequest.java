package com.salomovs.mastersys.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Optional;

import com.salomovs.mastersys.domain.Modality;

public record ModalityRequest (
  @NotBlank(message="Name field is missing")
  @Size(max=100, message="Name field can contain 50 characters at most")
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
