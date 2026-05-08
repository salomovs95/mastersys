package com.salomovs.mastersys.dto.request;

import com.salomovs.mastersys.domain.Address;
import com.salomovs.mastersys.domain.Student;

public record AddressRequest (
  String address,
  Integer number,
  String neighborhood,
  String complement,
  String city,
  String federalUnity,
  String zipCode
) {
  public Address toEntity(Student student) {
    Address ad = new Address(null, address, number, neighborhood, complement, city, federalUnity, zipCode, student);
    return ad;
  }
}
