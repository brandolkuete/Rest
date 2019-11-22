package com.brandolkuete.ScolarWebRest.dto.mapper;

import com.brandolkuete.ScolarWebRest.dto.RoleDto;
import com.brandolkuete.ScolarWebRest.entities.Role;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface RoleMapper extends EntityMapper<RoleDto,Role> {
}
