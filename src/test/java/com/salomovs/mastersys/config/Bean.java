package com.salomovs.mastersys.config;

import org.springframework.context.annotation.Configuration;

import com.salomovs.mastersys.repository.GraduationRepository;
import com.salomovs.mastersys.repository.ModalityRepository;
import com.salomovs.mastersys.repository.PlanRepository;
import com.salomovs.mastersys.service.PlanService;

@Configuration
public class Bean {

  @org.springframework.context.annotation.Bean
  public PlanService planService(
        GraduationRepository graduationRepo,
        ModalityRepository modalityRepo,
        PlanRepository plansRepo
  ) {
    return new PlanService(graduationRepo, modalityRepo, plansRepo);
  }

}
