package project.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
