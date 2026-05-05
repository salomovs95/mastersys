package com.salomovs.mastersys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salomovs.mastersys.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}
