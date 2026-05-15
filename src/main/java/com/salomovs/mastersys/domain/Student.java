package com.salomovs.mastersys.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name="address", column=@Column(name="address_street")),
    @AttributeOverride(name="number", column=@Column(name="address_number")),
    @AttributeOverride(name="neighborhood", column=@Column(name="address_neighborhood")),
    @AttributeOverride(name="complement", column=@Column(name="address_complement")),
    @AttributeOverride(name="city", column=@Column(name="address_city")),
    @AttributeOverride(name="federalUnity", column=@Column(name="address_state")),
    @AttributeOverride(name="zipCode", column=@Column(name="address_zip_code"))
  })
  private Address address;

  @OneToMany(mappedBy="student")
  private List<Contact> contacts;

  @PrePersist
  private void prePersist() {
    registeredAt = LocalDateTime.now();
  }

  @PreUpdate
  private void preUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
