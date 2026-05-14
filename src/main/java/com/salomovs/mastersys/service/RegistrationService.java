package com.salomovs.mastersys.service;

import com.salomovs.mastersys.domain.Graduation;
import com.salomovs.mastersys.domain.Modality;
import com.salomovs.mastersys.domain.Plan;
import com.salomovs.mastersys.domain.Registration;
import com.salomovs.mastersys.domain.RegistrationModality;
import com.salomovs.mastersys.domain.Student;
import com.salomovs.mastersys.dto.request.RegistrationModalityRequest;
import com.salomovs.mastersys.dto.request.RegistrationRequest;
import com.salomovs.mastersys.dto.response.RegistrationModalityResponse;
import com.salomovs.mastersys.dto.response.RegistrationResponse;
import com.salomovs.mastersys.repository.GraduationRepository;
import com.salomovs.mastersys.repository.ModalityRepository;
import com.salomovs.mastersys.repository.PlanRepository;
import com.salomovs.mastersys.repository.RegistrationModalityRepository;
import com.salomovs.mastersys.repository.RegistrationRepository;
import com.salomovs.mastersys.repository.StudentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrationService {
  private final GraduationRepository graduationRepository;
  private final ModalityRepository modalityRepository;
  private final PlanRepository plansRepository;
  private final StudentRepository studentsRepository;
  private final RegistrationRepository regsRepository;
  private final RegistrationModalityRepository regModalityRepo;

  public RegistrationResponse createRegistration(Long studentId, RegistrationRequest req) {
    Student student = studentsRepository.findById(studentId).orElseThrow(
      ()-> new RuntimeException("No Such entity")
    );
    Registration registration = req.toEntity(student);
    return RegistrationResponse.fromEntity(registration);
  }

  public Page<RegistrationResponse> listRegistrations(Pageable page) {
    Page<Registration> registrations = regsRepository.findAll(page);
    return registrations.map(RegistrationResponse::fromEntity);
  }

  public RegistrationResponse findRegistration(Long id) {
    Registration registration = findRegistrationById(id);
    return RegistrationResponse.fromEntity(registration);
  }

  private Registration findRegistrationById(Long id) {
    Registration registration = regsRepository.findById(id).orElseThrow(
      ()-> new RuntimeException("No sucu entity")
    );
    return registration;
  }

  public void updateRegistration(Long id, RegistrationRequest patch) {
    Registration registration = findRegistrationById(id);
    patch.fillUp(registration);
    regsRepository.save(registration);
  }



  public RegistrationModalityResponse saveRegistrationModality(
    Long planId, Long registrationId, Long modalityId, Long graduationId,
    RegistrationModalityRequest req
  ) {
    Plan plan = plansRepository.findById(planId).orElseThrow();
    Registration registration = findRegistrationById(registrationId);
    Modality modality = modalityRepository.findById(modalityId).orElseThrow();
    Graduation graduation = graduationRepository.findById(graduationId).orElseThrow();
    RegistrationModality regModality = regModalityRepo.save(req.toEntity(plan, registration, modality, graduation));
    return RegistrationModalityResponse.fromEntity(regModality);
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
      ()-> new RuntimeException("No such entity")
    );
    return reg;
  }

  public void updateModalityRegistration(Long id, RegistrationModalityRequest patch) {
    RegistrationModality regModality = findRegistrationModalityById(id);
    patch.fillUp(regModality);
    regModalityRepo.save(regModality);
  }
}
