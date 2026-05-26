package com.salomovs.mastersys.service;

import com.salomovs.mastersys.domain.Graduation;
import com.salomovs.mastersys.domain.Modality;
import com.salomovs.mastersys.domain.Plan;
import com.salomovs.mastersys.dto.request.GraduationRequest;
import com.salomovs.mastersys.dto.request.ModalityRequest;
import com.salomovs.mastersys.dto.request.PlanRequest;
import com.salomovs.mastersys.dto.response.GraduationResponse;
import com.salomovs.mastersys.dto.response.ModalityResponse;
import com.salomovs.mastersys.dto.response.PlanResponse;
import com.salomovs.mastersys.exception.BusinessInvariantViolationException;
import com.salomovs.mastersys.repository.GraduationRepository;
import com.salomovs.mastersys.repository.ModalityRepository;
import com.salomovs.mastersys.repository.PlanRepository;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PlanService {
  private final GraduationRepository graduationRepository;
  private final ModalityRepository modalityRepository;
  private final PlanRepository plansRepository;

  public PlanResponse createPlan(Long modalityId, PlanRequest req) {
    Modality modality = modalityRepository.findById(modalityId).orElseThrow(
      ()-> new BusinessInvariantViolationException("No Such modality")
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
      ()-> new BusinessInvariantViolationException("No Such Plan")
    );
  }

  public void updatePlan(Long id, PlanRequest patch) {
    Plan plan = findPlanById(id);
    patch.fillUp(plan);
    plansRepository.save(plan);
  }



  public ModalityResponse createModality(ModalityRequest req) {
    Modality modality = modalityRepository.save(req.toEntity());
    return ModalityResponse.fromEntity(modality);
  }

  public Page<ModalityResponse> listModalities(Pageable page) {
    Page<Modality> modalities = modalityRepository.findAll(page);
    return modalities.map(ModalityResponse::fromEntity);
  }

  public ModalityResponse findModality(Long id) {
    Modality modality = findModalityById(id);
    return ModalityResponse.fromEntity(modality);
  }

  private Modality findModalityById(Long modalityId) {
    Modality modality = modalityRepository.findById(modalityId).orElseThrow(
      ()-> new BusinessInvariantViolationException("No Modality Record Found")
    );
    return modality;
  }

  public void updateModality(Long id, ModalityRequest patch) {
    Modality modality = findModalityById(id);
    patch.fillUp(modality);
    modalityRepository.save(modality);
  }



  public GraduationResponse createGraduation(Long modalityId, GraduationRequest req) {
    Modality modality = findModalityById(modalityId);
    Graduation graduation = graduationRepository.save(req.toEntity(modality));
    return GraduationResponse.fronEntity(graduation);
  }

  public Page<GraduationResponse> listGraduations(Pageable page) {
    Page<Graduation> graduations = graduationRepository.findAll(page);
    return graduations.map(GraduationResponse::fronEntity);
  }

  public GraduationResponse findGraduation(Long id) {
    Graduation graduation = findGraduationById(id);
    return GraduationResponse.fronEntity(graduation);
  }

  private Graduation findGraduationById(Long id) {
    Graduation graduation = graduationRepository.findById(id).orElseThrow(
      ()-> new BusinessInvariantViolationException("No Graduation Record Found")
    );
    return graduation;
  }

  public void updateGraduation(Long id, GraduationRequest patch) {
    Graduation graduation = findGraduationById(id);
    patch.fillUp(graduation);
    graduationRepository.save(graduation);
  }

}
