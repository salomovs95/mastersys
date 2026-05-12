package com.salomovs.mastersys.dto.response;

import com.salomovs.mastersys.domain.Graduation;

public record GraduationResponse (
  Long id,
  String name,
  ModalityResponse modality
) {
  public static GraduationResponse fronEntity(Graduation graduation) {
    return new GraduationResponse(
      graduation.getId(),
      graduation.getName(),
      ModalityResponse.fromEntity(graduation.getModality())
    );
  }
}
