package com.salomovs.mastersys.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

import com.salomovs.mastersys.domain.Modality;
import com.salomovs.mastersys.domain.Plan;

public record PlanRequest (
  @NotEmpty(message="Name field is missing")
  @Size(max=100, message="Name field can contain 100 characters at most")
  String name,

  @NotNull(message="MonthlyPrice field is missing")
  @DecimalMin("1.00")
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
