package com.salomovs.mastersys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salomovs.mastersys.domain.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {}
