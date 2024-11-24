package project.address.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.address.dto.request.AddressDtoRequest;
import project.address.dto.response.AddressDtoResponse;
import project.address.entity.Address;
import project.address.mapper.AddressMapper;
import project.address.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    private final AddressMapper addressMapper;

    public AddressController(AddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }


    private Address toEntity(AddressDtoRequest request) {
        return addressMapper.toEntity(request);
    }

    private AddressDtoResponse toResponse(Address entity) {
        return addressMapper.toResponse(entity);
    }

}
