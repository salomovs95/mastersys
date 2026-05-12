package com.salomovs.mastersys.dto.request;

import java.time.LocalDate;

import com.salomovs.mastersys.domain.Graduation;
import com.salomovs.mastersys.domain.Modality;
import com.salomovs.mastersys.domain.Plan;
import com.salomovs.mastersys.domain.Registration;
import com.salomovs.mastersys.domain.RegistrationModality;

public record RegistrationModalityRequest (
  LocalDate startDate,
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
