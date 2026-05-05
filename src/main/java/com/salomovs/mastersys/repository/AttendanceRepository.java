package com.salomovs.mastersys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salomovs.mastersys.domain.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {}
