package com.salomovs.mastersys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salomovs.mastersys.domain.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {}
