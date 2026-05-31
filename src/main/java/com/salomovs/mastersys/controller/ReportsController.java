package com.salomovs.mastersys.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.salomovs.mastersys.doc.IReportsController;
import com.salomovs.mastersys.dto.projection.MonthlyIncomes;
import com.salomovs.mastersys.dto.projection.PendingInvoice;
import com.salomovs.mastersys.dto.projection.StudentPerCity;
import com.salomovs.mastersys.repository.ReportRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportsController implements IReportsController {

  private final ReportRepository reportRepository;

  @GetMapping("/monthly-incomes")
  @ResponseStatus(HttpStatus.OK)
  public List<MonthlyIncomes> monthlyIncomes() {
    return reportRepository.monthlyIncomes();
  }

  @GetMapping("/pending-invoices")
  @ResponseStatus(HttpStatus.OK)
  public List<PendingInvoice> pendingInvoices() {
    return reportRepository.pendingInvoices();
  }

  @GetMapping("/students-per-city")
  @ResponseStatus(HttpStatus.OK)
  public List<StudentPerCity> studentsPerCity() {
    return reportRepository.studentsPerCity();
  }

}
