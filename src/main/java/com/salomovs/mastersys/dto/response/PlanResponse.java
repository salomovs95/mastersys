package com.salomovs.mastersys.dto.response;

import java.math.BigDecimal;

import com.salomovs.mastersys.domain.Plan;

public record PlanResponse (
  Long id,
  String name,
  BigDecimal monthlyPrice,
  Boolean active,
  ModalityResponse modality
) {
  public static PlanResponse fromEntity(Plan plan) {
    return new PlanResponse(
      plan.getId(),
      plan.getName(),
      plan.getMonthlyPrice(),
      plan.getActive(),
      ModalityResponse.fromEntity(plan.getModality())
    );
  }
}
