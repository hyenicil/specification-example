package org.yenicilh.specificationexample.address.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yenicilh.specificationexample.address.dto.request.AddressDtoRequest;
import org.yenicilh.specificationexample.address.dto.response.AddressDtoResponse;
import org.yenicilh.specificationexample.address.entity.Address;
import org.yenicilh.specificationexample.address.mapper.AddressMapper;
import org.yenicilh.specificationexample.address.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    private final AddressMapper addressMapper;

    public AddressController(AddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @GetMapping("/{name}")
    public AddressDtoResponse getNameForAddress(@PathVariable String name) {
        return toResponse(addressService.getNameForAddress(name));
    }

    private Address toEntity(AddressDtoRequest request) {
        return addressMapper.toEntity(request);
    }

    private AddressDtoResponse toResponse(Address entity) {
        return addressMapper.toResponse(entity);
    }

}
