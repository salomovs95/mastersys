package com.salomovs.mastersys.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.salomovs.mastersys.config.Bean;
import com.salomovs.mastersys.domain.Graduation;
import com.salomovs.mastersys.domain.Modality;
import com.salomovs.mastersys.domain.Plan;
import com.salomovs.mastersys.repository.GraduationRepository;
import com.salomovs.mastersys.repository.ModalityRepository;
import com.salomovs.mastersys.repository.PlanRepository;

@WebMvcTest({PlanController.class, Bean.class})
public class ModalityPlanTest {

  @Autowired
  MockMvc mvc;

  @MockitoBean
  public GraduationRepository graduationRepo;

  @MockitoBean
  public ModalityRepository modalityRepo;

  @MockitoBean
  public PlanRepository plansRepo;

  @Test
  void createModality() {
    Modality m = new Modality(999l, "Name Modality", true);
    when(modalityRepo.save(Mockito.any(Modality.class)))
      .thenReturn(m);

    String payload = "{\"name\":\"Nane Modality\",\"active\": true}";
    assertDoesNotThrow(()->{
      mvc.perform(post("/modalities")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload));
    });
  }

  @Test
  void createPlan() {
    Modality m = new Modality(999l, "Name Modality", true);
    Plan p = new Plan(998l, "Name Plan Modality", BigDecimal.valueOf(55.95), true, m);

    when(modalityRepo.findById(Mockito.any(Long.class)))
      .thenReturn(Optional.of(m));

    when(plansRepo.save(Mockito.any(Plan.class)))
      .thenReturn(p);

    String payload = "{\"name\":\"Modality Plan\",\"monthlyPrice\": 55.89, \"active\":true}";
    assertDoesNotThrow(()->{
      mvc.perform(post("/modalities/999/plans")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload));
    });
  }

  @Test
  void createGraduation() {
    Modality m = new Modality(999l, "Name Modality", true);
    Graduation g = new Graduation(997l, "Name Graduation", m);

    when(modalityRepo.findById(Mockito.any(Long.class)))
      .thenReturn(Optional.of(m));

    when(graduationRepo.save(Mockito.any(Graduation.class)))
      .thenReturn(g);

    String payload = "{\"name\":\"Modality Graduation\"}";
    assertDoesNotThrow(()->{
      mvc.perform(post("/modalities/999/graduations")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload));
    });
  }

  @Test
  void retrievePlan() {
    Modality m = new Modality(999l, "Name Modality", true);
    when(modalityRepo.findById(Mockito.any(Long.class)))
      .thenReturn(Optional.of(m));

    assertDoesNotThrow(()->{
      mvc.perform(get("/modalities/999"));
    });
  }

}
