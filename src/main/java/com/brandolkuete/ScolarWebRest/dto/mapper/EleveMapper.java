package com.brandolkuete.ScolarWebRest.dto.mapper;

import com.brandolkuete.ScolarWebRest.dto.EleveDTO;
import com.brandolkuete.ScolarWebRest.entities.Eleve;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface EleveMapper extends EntityMapper<EleveDTO,Eleve> {
}
