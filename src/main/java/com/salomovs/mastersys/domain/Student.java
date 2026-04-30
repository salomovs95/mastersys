package com.salomovs.mastersys.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="students")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String taxId;
  private LocalDate birthdate;
  private String gender;

  private LocalDateTime registeredAt;
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy="student")
  private List<Contact> contacts;

  @OneToMany(mappedBy="student")
  private List<Address> addresses;

  @PrePersist
  private void prePersist() {
    registeredAt = LocalDateTime.now();
  }

  @PreUpdate
  private void preUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
