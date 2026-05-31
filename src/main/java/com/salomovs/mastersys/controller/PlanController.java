package com.salomovs.mastersys.controller;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.salomovs.mastersys.doc.IGraduationController;
import com.salomovs.mastersys.doc.IModalityController;
import com.salomovs.mastersys.doc.IPlanController;
import com.salomovs.mastersys.dto.request.GraduationRequest;
import com.salomovs.mastersys.dto.request.ModalityRequest;
import com.salomovs.mastersys.dto.request.PlanRequest;
import com.salomovs.mastersys.dto.response.GraduationResponse;
import com.salomovs.mastersys.dto.response.ModalityResponse;
import com.salomovs.mastersys.dto.response.PlanResponse;
import com.salomovs.mastersys.service.PlanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/modalities")
@RequiredArgsConstructor
public class PlanController implements IPlanController, IModalityController, IGraduationController {

  private final PlanService planService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ModalityResponse createModality(@RequestBody @Valid ModalityRequest body) {
    return planService.createModality(body);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Page<ModalityResponse> listModalities(Pageable page) {
    return planService.listModalities(page);
  }

  @GetMapping("/{modality_id}")
  @ResponseStatus(HttpStatus.OK)
  public ModalityResponse findModality(@PathVariable(name="modality_id") Long modalityId) {
    return planService.findModality(modalityId);
  }

  @PatchMapping("/{modality_id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateModality(@PathVariable(name="modality_id") Long modalityId, @RequestBody ModalityRequest body) {
    planService.updateModality(modalityId, body);
  }

  @PostMapping("/{modality_id}/plans")
  @ResponseStatus(HttpStatus.CREATED)
  public PlanResponse createPlan(@PathVariable(name="modality_id") Long modalityId, @RequestBody @Valid PlanRequest body) {
    return planService.createPlan(modalityId, body);
  }

  @GetMapping("/{modality_id}/plans")
  @ResponseStatus(HttpStatus.OK)
  public Page<PlanResponse> listPlans(@PathVariable(name="modality_id") Long modalityId, Pageable page) {
    return planService.listPlans(page);
  }

  @GetMapping("/{modality_id}/plans/{plan_id}")
  @ResponseStatus(HttpStatus.OK)
  public PlanResponse findPlanInfo(@PathVariable(name="plan_id") Long planId) {
    return planService.findPlan(planId);
  }

  @PatchMapping("/{modality_id}/plans/{plan_id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updatePlan(@PathVariable(name="modality_id") Long modalityId, @PathVariable(name="plan_id") Long planId, @RequestBody PlanRequest body) {
    planService.updatePlan(planId, body);
  }

  @PostMapping("/{modality_id}/graduations")
  @ResponseStatus(HttpStatus.CREATED)
  public GraduationResponse insertGraduation(@PathVariable(name="modality_id") Long modalityId, @RequestBody @Valid GraduationRequest body) {
    return planService.createGraduation(modalityId, body);
  }

  @GetMapping("/{modality_id}/graduations")
  @ResponseStatus(HttpStatus.OK)
  public Page<GraduationResponse> listGraduations(@PathVariable(name="modality_id") Long modalityId, Pageable page) {
    return planService.listGraduations(page);
  }

  @GetMapping("/{modality_id}/graduations/{graduation_id}")
  @ResponseStatus(HttpStatus.OK)
  public GraduationResponse findGraduation(@PathVariable(name="modality_id") Long modalityId, @PathVariable(name="graduation_id") Long graduationId) {
    return planService.findGraduation(graduationId);
  }

  @PatchMapping("/{modality_id}/graduations/{graduation_id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateGraduation(@PathVariable(name="modality_id") Long modalityId, @PathVariable(name="graduation_id") Long graduationId, @RequestBody GraduationRequest body) {
    planService.updateGraduation(graduationId, body);
  }

}
