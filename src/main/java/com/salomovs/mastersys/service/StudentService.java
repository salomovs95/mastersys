package com.salomovs.mastersys.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.salomovs.mastersys.domain.Student;
import com.salomovs.mastersys.dto.request.StudentRequest;
import com.salomovs.mastersys.dto.response.StudentResponse;
import com.salomovs.mastersys.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentsRepo;

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

}        
