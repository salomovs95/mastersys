package com.salomovs.mastersys.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.salomovs.mastersys.domain.Attendance;
import com.salomovs.mastersys.domain.Registration;
import com.salomovs.mastersys.domain.Student;
import com.salomovs.mastersys.dto.request.AttendanceRequest;
import com.salomovs.mastersys.dto.request.StudentRequest;
import com.salomovs.mastersys.dto.response.AttendanceResponse;
import com.salomovs.mastersys.dto.response.StudentResponse;
import com.salomovs.mastersys.repository.AttendanceRepository;
import com.salomovs.mastersys.repository.RegistrationRepository;
import com.salomovs.mastersys.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentsRepo;
  private final AttendanceRepository attendanceRepository;
  private final RegistrationRepository registrationRepo;

  public StudentResponse registerStudent(StudentRequest req) {
    Student student = studentsRepo.save(req.toEntity());
    return StudentResponse.fromEntity(student);
  }

  public void updateStudent(Long id, StudentRequest req) {
    Student student = findById(id);
    req.fillUp(student);
    studentsRepo.save(student);
  }

  public Page<StudentResponse> listStudents(Pageable page) {
    Page<Student> students = studentsRepo.findAll(page);
    return students.map(StudentResponse::fromEntity);
  }

  public void removeStudent(Long id) {
    studentsRepo.deleteById(id);
  }

  public StudentResponse findStudent(Long id) {
    Student student = findById(id);
    return StudentResponse.fromEntity(student);
  }

  private Student findById(Long id) {
    Student student = studentsRepo.findById(id).orElseThrow(()->
      new RuntimeException("Data not found"));

    return student;
  }



  public AttendanceResponse saveAttendance(Long registrationId, AttendanceRequest req) {
    Registration registration = registrationRepo.findById(registrationId).orElseThrow(
      ()-> new RuntimeException("No such entity")
    );
    Attendance attendance = attendanceRepository.save(req.toEntity(registration));
    return AttendanceResponse.fromEntity(attendance);
  }

  public Page<AttendanceResponse> listAttendaances(Pageable page) {
    Page<Attendance> attendances = attendanceRepository.findAll(page);
    return attendances.map(AttendanceResponse::fromEntity);
  }

  public AttendanceResponse findAttendance(Long id) {
    Attendance attendance = findAttendanceById(id);
    return AttendanceResponse.fromEntity(attendance);
  }

  public Attendance findAttendanceById(Long id) {
    Attendance attendance = attendanceRepository.findById(id).orElseThrow(
      ()-> new RuntimeException("No such entity")
    );
    return attendance;
  }

  public void updateAttendance(Long attendanceId, AttendanceRequest patch) {
    Attendance attendance = findAttendanceById(attendanceId);
    patch.fillUp(attendance);
    attendanceRepository.save(attendance);
  }

}
