package com.salomovs.mastersys.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class ReportsTest {

  @Autowired
  private MockMvc mvc;

  @Test
  void studentsPerCity() {
    assertDoesNotThrow(()->mvc.perform(get("/reports/students-per-city")));
  }

  @Test
  void monthlyIncomes() {
    assertDoesNotThrow(()->mvc.perform(get("/reports/monthly-incomes")));
  }

  @Test
  void pendingInvoices() {
    assertDoesNotThrow(()->mvc.perform(get("/reports/pending-invoices")));
  }

}
