package com.salomovs.mastersys.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import com.salomovs.mastersys.domain.Graduation;
import com.salomovs.mastersys.domain.Modality;
import com.salomovs.mastersys.domain.Plan;
import com.salomovs.mastersys.domain.Registration;
import com.salomovs.mastersys.domain.RegistrationModality;

public record RegistrationModalityRequest (
  @NotNull(message="StartDate field is missing")
  @FutureOrPresent(message="Past StartDaten field is not allowed")
  LocalDate startDate,

  @NotNull(message="FinishDate field is missing")
  @Future(message="FinishDate field must be a future date")
  LocalDate finishDate
) {
  public RegistrationModality toEntity(Plan plan, Registration registration, Modality modality, Graduation graduation) {
    RegistrationModality registrationModality = new RegistrationModality();
    fillUp(registrationModality);
    registrationModality.setPlan(plan);
    registrationModality.setRegistration(registration);
    registrationModality.setModality(modality);
    registrationModality.setGraduation(graduation);
    return registrationModality;
  }

  public void fillUp(RegistrationModality entity) {
    if (startDate != null)
      entity.setStartDate(startDate);

    if (finishDate != null)
      entity.setFinishDate(finishDate);
  }
}
