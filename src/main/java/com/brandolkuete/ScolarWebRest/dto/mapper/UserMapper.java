package com.brandolkuete.ScolarWebRest.dto.mapper;

import com.brandolkuete.ScolarWebRest.dto.UseDto;
import com.brandolkuete.ScolarWebRest.entities.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface UserMapper extends EntityMapper<UseDto,User> {
}
