package com.salomovs.mastersys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salomovs.mastersys.domain.RegistrationInvoice;

public interface InvoiceRepository extends JpaRepository<RegistrationInvoice, Long> {}
