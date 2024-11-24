package org.yenicilh.specificationexample.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yenicilh.specificationexample.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findByCity(String name);
}
