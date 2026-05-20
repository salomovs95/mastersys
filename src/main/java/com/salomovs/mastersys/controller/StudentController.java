package com.salomovs.mastersys.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.salomovs.mastersys.dto.filter.StudentFilter;
import com.salomovs.mastersys.dto.request.AttendanceRequest;
import com.salomovs.mastersys.dto.request.StudentRequest;
import com.salomovs.mastersys.dto.response.AttendanceResponse;
import com.salomovs.mastersys.dto.response.StudentResponse;
import com.salomovs.mastersys.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentsService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public StudentResponse registerStudent(@RequestBody @Valid StudentRequest req) {
    StudentResponse newStudent = studentsService.registerStudent(req);
    return newStudent;
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public StudentResponse findStudent(@PathVariable Long id) {
    return studentsService.findStudent(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Page<StudentResponse> listStudents(StudentFilter filter, Pageable page) {
    return studentsService.listStudents(filter, page);
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void updateStudentRegistry(@PathVariable Long id, @RequestBody @Valid StudentRequest req) {
    studentsService.updateStudent(id, req);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteStudent(Long id) {
    studentsService.removeStudent(id);
  }



  @PostMapping("/{registration_id}/attendances")
  @ResponseStatus(HttpStatus.CREATED)
  public AttendanceResponse createAttendance(@PathVariable(name="registration_id") Long registrationId, @RequestBody @Valid AttendanceRequest body) {
    AttendanceResponse attendance = studentsService.saveAttendance(registrationId, body);
    return attendance;
  }

  @GetMapping("/attendances")
  @ResponseStatus(HttpStatus.OK)
  public Page<AttendanceResponse> listAttendances(Pageable page) {
    Page<AttendanceResponse> attendances = studentsService.listAttendaances(page);
    return attendances;
  }

  @GetMapping("/attendances/{attendance_id}")
  @ResponseStatus(HttpStatus.OK)
  public AttendanceResponse getAttendanceInfo(@PathVariable(name="attendance_id") Long attendanceId) {
    AttendanceResponse attendance = studentsService.findAttendance(attendanceId);
    return attendance;
  }

  @PatchMapping("/attendances/{attendance_id}")
  @ResponseStatus(HttpStatus.OK)
  public void updateAttendance(@PathVariable(name="attendance_id") Long attendanceId, @RequestBody @Valid AttendanceRequest body) {
    studentsService.updateAttendance(attendanceId, body);
  }

}
