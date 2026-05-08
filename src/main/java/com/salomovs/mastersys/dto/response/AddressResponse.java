package com.salomovs.mastersys.dto.response;

import com.salomovs.mastersys.domain.Address;

public record AddressResponse (
  Long id,
  String address,
  Integer number,
  String neighborhood,
  String complement,
  String city,
  String federalUnity,
  String zipCode
) {
  public static AddressResponse fromEntity(Address a) {
    return new AddressResponse(
      a.getId(),
      a.getAddress(),
      a.getNumber(),
      a.getNeighborhood(),
      a.getComplement(),
      a.getCity(),
      a.getFederalUnity(),
      a.getZipCode()
    );
  }
}
