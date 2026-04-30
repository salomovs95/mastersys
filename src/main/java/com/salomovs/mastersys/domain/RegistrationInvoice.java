package com.salomovs.mastersys.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.salomovs.mastersys.domain.enums.InvoiceStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="registration_invoices")
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationInvoice {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private LocalDate dueDate;
  private LocalDateTime paymentDate;
  private LocalDate cancelmentDate;

  private BigDecimal invoiceValue;

  @Enumerated(EnumType.STRING)
  private InvoiceStatus status = InvoiceStatus.OPEN;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="registration_id")
  private Registration registration;
}
