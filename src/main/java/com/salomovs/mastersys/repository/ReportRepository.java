package com.salomovs.mastersys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.Repository;

import com.salomovs.mastersys.domain.RegistrationInvoice;
import com.salomovs.mastersys.dto.projection.MonthlyIncomes;
import com.salomovs.mastersys.dto.projection.PendingInvoice;
import com.salomovs.mastersys.dto.projection.StudentPerCity;


public interface ReportRepository extends Repository<RegistrationInvoice, Long> {

  @NativeQuery("""
    SELECT
      SUM(invoice_value) AS total,
      TO_CHAR(due_date) AS dueDate
    FROM registration_invoices
    WHERE status = 'PAID'
    GROUP BY dueDate
    ORDER BY dueDate
  """)
  List<MonthlyIncomes> monthlyIncomes();

  @NativeQuery("""
    SELECT
      address_city AS city,
      COUNT(*) AS quantity
    FROM students
    GROUP BY city
    ORDER BY quantity
  """)
  List<StudentPerCity> studentsPerCity();

  @NativeQuery("""
    SELECT
      r.id AS registrationId,
      s.name AS studentName,
      i.invoice_value AS invoiceValue,
      i.due_date AS dueDate
    FROM registration_invoices i
    JOIN registrations r ON i.registration_id = r.id
    JOIN students s ON s.id = r.student_id
    WHERE i.status = 'OPEN'
    ORDER BY i.invoice_value DESC
  """)
  List<PendingInvoice> pendingInvoices();

}
