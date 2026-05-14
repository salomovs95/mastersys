package com.salomovs.mastersys.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.salomovs.mastersys.domain.Registration;
import com.salomovs.mastersys.domain.RegistrationInvoice;
import com.salomovs.mastersys.domain.enums.InvoiceStatus;

public record RegistrationInvoiceRequest (
  @NotNull(message="DueDate field is missing")
  @FutureOrPresent(message="Past DueDate field is not allowed")
  LocalDate dueDate,

  @NotNull(message="PaymentDate field is missing")
  @FutureOrPresent(message="Past PaymentDate field is not allowed")
  LocalDateTime paymentDate,

  @NotNull(message="CancelmentDate field is missing")
  @FutureOrPresent(message="Past CancelmentDate field is not allowed")
  LocalDate cancelmentDate,

  @NotNull(message="InvoiceValue field is missing")
  @DecimalMin(value="1.00", message="Zero or Negative values are not allowed")
  BigDecimal invoiceValue,

  @NotNull(message="Status field is missing")
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
