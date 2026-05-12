package com.salomovs.mastersys.dto.response;

import java.time.LocalDate;

import com.salomovs.mastersys.domain.RegistrationModality;

public record RegistrationModalityResponse (
  Long id,
  RegistrationResponse registration,
  ModalityResponse modality,
  GraduationResponse graduation,
  PlanResponse plan,
  LocalDate startDate,
  LocalDate finishDate
) {
  public static RegistrationModalityResponse fromEntity(RegistrationModality entity) {
    return new RegistrationModalityResponse(
      entity.getId(),
      RegistrationResponse.fromEntity(entity.getRegistration()),
      ModalityResponse.fromEntity(entity.getModality()),
      GraduationResponse.fronEntity(entity.getGraduation()),
      PlanResponse.fromEntity(entity.getPlan()),
      entity.getStartDate(),
      entity.getFinishDate()
    );
  }
}
