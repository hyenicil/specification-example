package org.yenicilh.specificationexample.address.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.yenicilh.specificationexample.address.dto.request.AddressDtoRequest;
import org.yenicilh.specificationexample.address.dto.response.AddressDtoResponse;
import org.yenicilh.specificationexample.address.entity.Address;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper( componentModel = SPRING, uses = {AddressMapper.class},injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AddressMapper {

    Address toEntity(AddressDtoRequest request);

    AddressDtoResponse toResponse(Address entity);

    List<AddressDtoResponse> toResponseList(List<Address> entities);

}
