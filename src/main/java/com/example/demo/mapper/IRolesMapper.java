package com.example.demo.mapper;

import com.example.demo.dto.user.RoleDto;
import com.example.demo.model.authority.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IRolesMapper {

    IRolesMapper INSTANCE = Mappers.getMapper(IRolesMapper.class);

    List<RoleDto> mapRolestoDTO(List<Roles> roles);
}
