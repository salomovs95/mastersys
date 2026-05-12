package com.salomovs.mastersys.dto.response;

import com.salomovs.mastersys.domain.Modality;

public record ModalityResponse (
  Long id,
  String name,
  Boolean active
) {
  public static ModalityResponse fromEntity(Modality modality) {
    return new ModalityResponse(
      modality.getId(),
      modality.getName(),
      modality.getActive()
    );
  }
}
