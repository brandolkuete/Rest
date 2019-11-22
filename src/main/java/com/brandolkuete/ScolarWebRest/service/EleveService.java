package com.brandolkuete.ScolarWebRest.service;

import com.brandolkuete.ScolarWebRest.dto.EleveDTO;
import com.brandolkuete.ScolarWebRest.entities.Eleve;

public interface EleveService extends EntityService<EleveDTO, Long> {
    public Eleve findByMatricule(String matricule);
}
