package com.brandolkuete.ScolarWebRest.dto.mapper;

import com.brandolkuete.ScolarWebRest.dto.EnseignantDTO;
import com.brandolkuete.ScolarWebRest.entities.Enseignant;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface EnseignantMapper extends EntityMapper<EnseignantDTO,Enseignant> {
}
