package com.salomovs.mastersys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salomovs.mastersys.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {}
