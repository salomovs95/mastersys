package com.salomovs.mastersys.service;

import com.salomovs.mastersys.domain.Graduation;
import com.salomovs.mastersys.domain.Plan;
import com.salomovs.mastersys.domain.Registration;
import com.salomovs.mastersys.domain.RegistrationModality;
import com.salomovs.mastersys.domain.Student;
import com.salomovs.mastersys.dto.request.RegistrationModalityRequest;
import com.salomovs.mastersys.dto.request.RegistrationRequest;
import com.salomovs.mastersys.dto.response.RegistrationModalityResponse;
import com.salomovs.mastersys.exception.BusinessInvariantViolationException;
import com.salomovs.mastersys.repository.GraduationRepository;
import com.salomovs.mastersys.repository.PlanRepository;
import com.salomovs.mastersys.repository.RegistrationModalityRepository;
import com.salomovs.mastersys.repository.RegistrationRepository;
import com.salomovs.mastersys.repository.StudentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RegistrationService {
  private final GraduationRepository graduationRepository;
  private final PlanRepository plansRepository;
  private final StudentRepository studentsRepository;
  private final RegistrationRepository regsRepository;
  private final RegistrationModalityRepository regModalityRepo;

  public void createRegistration(Long studentId, Long planId, Long graduationId, RegistrationRequest req) {
    Plan plan = plansRepository.findById(planId).orElseThrow(
      ()-> new BusinessInvariantViolationException("No Plan Record Found")
    );
    Student student = studentsRepository.findById(studentId).orElseThrow(
      ()-> new BusinessInvariantViolationException("No Student Record Found")
    );
    Graduation graduation = graduationRepository.findById(graduationId).orElseThrow(
      ()-> new BusinessInvariantViolationException("No Graduation Record Found")
    );

    Registration registration = regsRepository.save(req.toEntity(student));
    regModalityRepo.save(req.registrationModality().toEntity(plan, registration, plan.getModality(), graduation));
  }

  public Page<RegistrationModalityResponse> listRegistrationModalities(Pageable page) {
    Page<RegistrationModality> regies = regModalityRepo.findAll(page);
    return regies.map(RegistrationModalityResponse::fromEntity);
  }

  public RegistrationModalityResponse fundRegistrationModality(Long regId) {
    RegistrationModality reg = findRegistrationModalityById(regId);
    return RegistrationModalityResponse.fromEntity(reg);
  }

  private RegistrationModality findRegistrationModalityById(Long regId) {
    RegistrationModality reg = regModalityRepo.findById(regId).orElseThrow(
      ()-> new BusinessInvariantViolationException("No Registratiom Modality Record Found")
    );
    return reg;
  }

  private Registration findRegistrationById(Long id) {
    Registration registration = regsRepository.findById(id).orElseThrow(
      ()-> new BusinessInvariantViolationException("No Registration Record Found")
    );
    return registration;
  }

  public void updateRegistration(Long regId, RegistrationRequest patch) {
    Registration registration = findRegistrationById(regId);
    patch.fillUp(registration);
    regsRepository.save(registration);
  }

  public void updateModalityRegistration(Long id, RegistrationModalityRequest patch) {
    RegistrationModality regModality = findRegistrationModalityById(id);
    patch.fillUp(regModality);
    regModalityRepo.save(regModality);
  }
}
