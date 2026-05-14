package com.salomovs.mastersys.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.salomovs.mastersys.domain.Address;

public record AddressRequest (
  @NotBlank(message="Address field is missing")
  @Size(max=150, message="Address field can contain 150 characters at most")
  String address,

  @NotBlank(message="Number field is missing")
  @Size(max=4, message="Number field can contain 4 characters at most")
  Integer number,

  @NotBlank(message="Neighborhood field is missing")
  @Size(max=100, message="Neighborhood field can contain 100 characters at most")
  String neighborhood,

  @NotBlank(message="Complement field is missing")
  @Size(max=20, message="Complement field can contain 50 characters at most")
  String complement,

  @NotBlank(message="City field is missing")
  @Size(max=20, message="City field can contain 50 characters at most")
  String city,

  @NotBlank(message="FederalUnity field is missing")
  @Size(max=2, message="FederalUnity field can contain 2 characters at most")
  String federalUnity,

  @NotBlank(message="ZipCode field is missing")
  @Size(max=20, message="ZipCode field can contain 10 characters at most")
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
