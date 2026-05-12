package com.salomovs.mastersys.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.salomovs.mastersys.domain.RegistrationInvoice;
import com.salomovs.mastersys.domain.enums.InvoiceStatus;

public record RegistrationInvoiceResponse (
  Long id,
  LocalDate dueDate,
  LocalDateTime paymentDate,
  LocalDate cancelmentDate,
  BigDecimal invoiceValue,
  InvoiceStatus status,
  RegistrationResponse registration
) {
  public static RegistrationInvoiceResponse fromEntity(RegistrationInvoice invoice) {
    return new RegistrationInvoiceResponse(
      invoice.getId(),
      invoice.getDueDate(),
      invoice.getPaymentDate(),
      invoice.getCancelmentDate(),
      invoice.getInvoiceValue(),
      invoice.getStatus(),
      RegistrationResponse.fromEntity(invoice.getRegistration())
    );
  }
}
