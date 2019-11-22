package com.brandolkuete.ScolarWebRest.service;

import com.brandolkuete.ScolarWebRest.dto.EnseignantDTO;
import com.brandolkuete.ScolarWebRest.entities.Enseignant;

public interface EnseignantService extends EntityService<EnseignantDTO, Long> {
    public Enseignant findByTelephone(String telephone);
}
