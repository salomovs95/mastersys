package com.salomovs.mastersys.dto.projection;

import java.math.BigDecimal;

public interface MonthlyIncomes {
  String getDueDate();
  BigDecimal getTotal();
}
