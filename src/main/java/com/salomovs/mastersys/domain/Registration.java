package com.salomovs.mastersys.domain;

import java.time.LocalDate;

import com.salomovs.mastersys.domain.enums.RegistrationStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="registrations")
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private LocalDate registrationDate;
  private LocalDate closingDate;
  private Integer dueDay;

  @Enumerated(EnumType.STRING)
  private RegistrationStatus status = RegistrationStatus.ACTIVE;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="student_id")
  private Student student;

  @PrePersist
  private void prePersist() {
    if (registrationDate != null) return;
    registrationDate = LocalDate.now();
  }
}
