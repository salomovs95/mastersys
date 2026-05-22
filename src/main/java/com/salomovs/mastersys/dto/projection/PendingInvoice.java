package com.salomovs.mastersys.dto.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PendingInvoice {
  Long getRegistrationId();
  String getStudentName();
  LocalDate getDueDate();
  BigDecimal getInvoiceValue();
}
