package com.salomovs.mastersys.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.salomovs.mastersys.domain.Registration;
import com.salomovs.mastersys.domain.RegistrationInvoice;
import com.salomovs.mastersys.domain.enums.InvoiceStatus;

public record RegistrationInvoiceRequest (
  LocalDate dueDate,
  LocalDateTime paymentDate,
  LocalDate cancelmentDate,
  BigDecimal invoiceValue,
  InvoiceStatus status
){

  public RegistrationInvoice toEntity(Registration registration) {
    RegistrationInvoice invoice = new RegistrationInvoice();
    fillUp(invoice);
    invoice.setRegistration(registration);
    return invoice;
  }

  public void fillUp(RegistrationInvoice invoice) {
    if (dueDate != null)
      invoice.setDueDate(dueDate);

    if (paymentDate != null)
      invoice.setPaymentDate(paymentDate);

    if (cancelmentDate != null)
      invoice.setCancelmentDate(cancelmentDate);

    if (invoiceValue != null)
      invoice.setInvoiceValue(invoiceValue);

    if (status != null)
      invoice.setStatus(status);
  }
}
