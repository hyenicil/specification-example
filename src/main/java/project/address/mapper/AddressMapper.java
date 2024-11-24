package project.address.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import project.address.dto.request.AddressDtoRequest;
import project.address.dto.response.AddressDtoResponse;
import project.address.entity.Address;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper( componentModel = SPRING, uses = {AddressMapper.class},injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AddressMapper {

    Address toEntity(AddressDtoRequest request);

    AddressDtoResponse toResponse(Address entity);

    List<AddressDtoResponse> toResponseList(List<Address> entities);

}
