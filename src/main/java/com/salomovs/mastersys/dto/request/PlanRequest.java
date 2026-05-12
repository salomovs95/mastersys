package com.salomovs.mastersys.dto.request;

import java.math.BigDecimal;

import com.salomovs.mastersys.domain.Modality;
import com.salomovs.mastersys.domain.Plan;

public record PlanRequest (
  String name,
  BigDecimal monthlyPrice,
  Boolean active
) {
  public Plan toEntity(Modality modality) {
    Plan plan = new Plan();
    fillUp(plan);
    plan.setModality(modality);
    return plan;
  }

  public void fillUp(Plan plan) {
    if (name != null)
      plan.setName(name);

    if (monthlyPrice != null)
      plan.setMonthlyPrice(monthlyPrice);

    if (active != null)
      plan.setActive(active);
  }
}
