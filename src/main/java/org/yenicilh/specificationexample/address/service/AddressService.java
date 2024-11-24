package org.yenicilh.specificationexample.address.service;

import org.springframework.stereotype.Service;
import org.yenicilh.specificationexample.address.entity.Address;
import org.yenicilh.specificationexample.address.repository.AddressRepository;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address getNameForAddress(String name) {
        return addressRepository.findByCity(name);
    }
}
