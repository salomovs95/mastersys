package com.salomovs.mastersys.service;

import com.salomovs.mastersys.domain.Modality;
import com.salomovs.mastersys.domain.Plan;
import com.salomovs.mastersys.dto.request.PlanRequest;
import com.salomovs.mastersys.dto.response.PlanResponse;
import com.salomovs.mastersys.repository.ModalityRepository;
import com.salomovs.mastersys.repository.PlanRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanService {
  private final ModalityRepository modalityRepository;
  private final PlanRepository plansRepository;

  public PlanResponse createPlan(Long modalityId, PlanRequest req) {
    Modality modality = modalityRepository.findById(modalityId).orElseThrow(
      ()-> new RuntimeException("No such modality")
    );
    Plan plan = plansRepository.save(req.toEntity(modality));
    return PlanResponse.fromEntity(plan);
  }

  public Page<PlanResponse> listPlans(Pageable page) {
    Page<Plan> plans = plansRepository.findAll(page);
    return plans.map(PlanResponse::fromEntity);
  }

  public PlanResponse findPlan(Long planId) {
    Plan plan = findPlanById(planId);
    return PlanResponse.fromEntity(plan);
  }

  private Plan findPlanById(Long id) {
    return plansRepository.findById(id).orElseThrow(
      ()-> new RuntimeException("No Such entity")
    );
  }

  public void updatePlan(Long id, PlanRequest patch) {
    Plan plan = findPlanById(id);
    patch.fillUp(plan);
    plansRepository.save(plan);
  }
}
