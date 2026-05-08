package com.salomovs.mastersys.dto.request;

import com.salomovs.mastersys.domain.Address;

public record AddressRequest (
  String address,
  Integer number,
  String neighborhood,
  String complement,
  String city,
  String federalUnity,
  String zipCode
) {
  public Address toEntity() {
    Address ad = new Address(null, address, number, neighborhood, complement, city, federalUnity, zipCode);
    return ad;
  }
}
