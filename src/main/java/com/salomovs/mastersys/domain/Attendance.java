package com.salomovs.mastersys.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="attendances")
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime attendanceStartDate;
  private LocalDateTime attendanceEndDate;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="registration_id")
  private Registration registration;

  @PrePersist
  private void prePersist() {
    if (attendanceStartDate != null) return;
    attendanceStartDate = LocalDateTime.now();
  }
}
