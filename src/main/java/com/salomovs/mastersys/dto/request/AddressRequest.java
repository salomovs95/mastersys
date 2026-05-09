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
    Address ad = new Address();
    fillUp(ad);
    return ad;
  }

  public void fillUp(Address entity) {
    if (address != null)
      entity.setAddress(address);

    if (number != null)
      entity.setNumber(number);

    if (neighborhood != null)
       entity.setNeighborhood(neighborhood);

     if (complement != null)
       entity.setComplement(complement);

     if (city != null)
       entity.setCity(city);

     if (federalUnity != null)
       entity.setFederalUnity(federalUnity);

     if (zipCode != null)
       entity.setZipCode(zipCode);
  }
}
