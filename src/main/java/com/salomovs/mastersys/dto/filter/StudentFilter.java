package com.salomovs.mastersys.dto.filter;

public record StudentFilter(
  Long id,
  String taxId,
  String name,
  String email,
  String phoneNumber,
  String gender,
  String city,
  String state
) {}
