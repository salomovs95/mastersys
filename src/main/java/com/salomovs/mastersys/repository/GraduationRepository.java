package com.salomovs.mastersys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salomovs.mastersys.domain.Graduation;

public interface GraduationRepository extends JpaRepository<Graduation, Long> {}
