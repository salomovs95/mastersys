package com.salomovs.mastersys.controller;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salomovs.mastersys.dto.request.RegistrationModalityRequest;
import com.salomovs.mastersys.dto.request.RegistrationRequest;
import com.salomovs.mastersys.dto.response.RegistrationModalityResponse;
import com.salomovs.mastersys.service.RegistrationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/registrations")
@RequiredArgsConstructor
public class RegistrationController {

  private final RegistrationService registrationService;

  @PostMapping
  public void registrate(
      @RequestParam(name="student") Long studentId,
      @RequestParam(name="plan") Long planId,
      @RequestParam(name="graduation") Long graduationId,
      @RequestBody @Valid RegistrationRequest body) {

    registrationService.createRegistration(studentId, planId, graduationId, body);
  }

  @PatchMapping("/{reg_id}")
  public void updateRegistration(@PathVariable Long regId, RegistrationRequest body) {
    registrationService.updateRegistration(regId, body);
  }

  @PatchMapping("/modalities/{registration_modality_id}")
  public void updateModalityRegistration(@PathVariable Long regId, RegistrationModalityRequest body) {
    registrationService.updateModalityRegistration(regId, body);
  }

  @GetMapping("/modalities")
  public Page<RegistrationModalityResponse> listRegistry(Pageable page) {
    return registrationService.listRegistrationModalities(page);
  }

  @GetMapping("/modalities/{registration_modality_id}")
  public RegistrationModalityResponse findRegistry(Long regId) {
    return registrationService.findRegistrationModality(regId);
  }

}
