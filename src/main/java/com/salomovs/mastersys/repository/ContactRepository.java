package com.salomovs.mastersys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salomovs.mastersys.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {}
