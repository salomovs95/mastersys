package com.salomovs.mastersys.service;

import com.salomovs.mastersys.domain.Graduation;
import com.salomovs.mastersys.domain.Modality;
import com.salomovs.mastersys.domain.Plan;
import com.salomovs.mastersys.domain.Registration;
import com.salomovs.mastersys.domain.RegistrationModality;
import com.salomovs.mastersys.domain.Student;
import com.salomovs.mastersys.dto.request.GraduationRequest;
import com.salomovs.mastersys.dto.request.ModalityRequest;
import com.salomovs.mastersys.dto.request.PlanRequest;
import com.salomovs.mastersys.dto.request.RegistrationModalityRequest;
import com.salomovs.mastersys.dto.request.RegistrationRequest;
import com.salomovs.mastersys.dto.response.GraduationResponse;
import com.salomovs.mastersys.dto.response.ModalityResponse;
import com.salomovs.mastersys.dto.response.PlanResponse;
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
public class MembershipService {
  private final GraduationRepository graduationRepository;
  private final ModalityRepository modalityRepository;
  private final PlanRepository plansRepository;
  private final StudentRepository studentsRepository;
  private final RegistrationRepository regsRepository;
  private RegistrationModalityRepository regModalityRepo;

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
      ()-> new RuntimeException("No Such entity")
    );
    return modality;
  }

  public void updateModality(Long id, ModalityRequest patch) {
    Modality modality = findModalityById(id);
    patch.fillUp(modality);
    modalityRepository.save(modality);
  }



  public PlanResponse createPlan(Long modalityId, PlanRequest req) {
    Modality modality = findModalityById(modalityId);
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
      ()-> new RuntimeException("No such entity")
    );
    return graduation;
  }

  public void updateGraduation(Long id, GraduationRequest patch) {
    Graduation graduation = findGraduationById(id);
    patch.fillUp(graduation);
    graduationRepository.save(graduation);
  }



  public RegistrationModalityResponse saveRegistrationModality(
    Long planId, Long registrationId, Long modalityId, Long graduationId,
    RegistrationModalityRequest req
  ) {
    Plan plan = findPlanById(planId);
    Registration registration = findRegistrationById(registrationId);
    Modality modality = findModalityById(modalityId);
    Graduation graduation = findGraduationById(graduationId);
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
