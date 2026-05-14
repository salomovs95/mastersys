package com.salomovs.mastersys.service;

import com.salomovs.mastersys.domain.Registration;
import com.salomovs.mastersys.domain.RegistrationInvoice;
import com.salomovs.mastersys.dto.request.RegistrationInvoiceRequest;
import com.salomovs.mastersys.dto.response.RegistrationInvoiceResponse;
import com.salomovs.mastersys.repository.InvoiceRepository;
import com.salomovs.mastersys.repository.RegistrationRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceService {
  private final InvoiceRepository invoiceRepository;
  private final RegistrationRepository registrationRepository;

  public RegistrationInvoiceResponse generateInvoice(Long registrationId, RegistrationInvoiceRequest req) {
    Registration registration = registrationRepository.findById(registrationId).orElseThrow();
    RegistrationInvoice invoice = invoiceRepository.save(req.toEntity(registration));
    return RegistrationInvoiceResponse.fromEntity(invoice);
  }

  public Page<RegistrationInvoiceResponse> listInvoices(Pageable page) {
    Page<RegistrationInvoice> invoices = invoiceRepository.findAll(page);
    return invoices.map(RegistrationInvoiceResponse::fromEntity);
  }

  public RegistrationInvoiceResponse findInvoice(Long invoiceId) {
    RegistrationInvoice invoice = findInvoiceById(invoiceId);
    return RegistrationInvoiceResponse.fromEntity(invoice);
  }

  private RegistrationInvoice findInvoiceById(Long id) {
    RegistrationInvoice invoice = invoiceRepository.findById(id).orElseThrow();
    return invoice;
  }

  public void updateInvoice(Long invoiceId, RegistrationInvoiceRequest patch) {
    RegistrationInvoice invoice = findInvoiceById(invoiceId);
    patch.fillUp(invoice);
    invoiceRepository.save(invoice);
  }

}
