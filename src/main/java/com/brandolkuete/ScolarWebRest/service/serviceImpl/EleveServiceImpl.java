package com.brandolkuete.ScolarWebRest.service.serviceImpl;

import com.brandolkuete.ScolarWebRest.dto.EleveDTO;
import com.brandolkuete.ScolarWebRest.dto.mapper.EleveMapper;
import com.brandolkuete.ScolarWebRest.entities.Eleve;
import com.brandolkuete.ScolarWebRest.repository.EleveRepository;
import com.brandolkuete.ScolarWebRest.service.EleveService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EleveServiceImpl implements EleveService {

    private final EleveRepository eleveRepository;
    private final EleveMapper eleveMapper;

    public EleveServiceImpl(EleveRepository eleveRepository, EleveMapper eleveMapper) {
        this.eleveRepository = eleveRepository;
        this.eleveMapper = eleveMapper;
    }

    @Override
    public EleveDTO save(EleveDTO entityDTO) {
       final Eleve eleve = eleveMapper.toEntity(entityDTO);
        return eleveMapper.toDto(eleveRepository.save(eleve));
    }

    @Override
    public EleveDTO update(EleveDTO entityDTO) {
            Eleve eleve= eleveMapper.toEntity(entityDTO);
            Eleve eleve1 = eleveRepository.findByMatricule(entityDTO.getMatricule());
            eleve.setId(eleve1.getId());
            eleve = eleveRepository.save(eleve);

        return eleveMapper.toDto(eleve);
    }

    @Override
    public List<EleveDTO> findAll() {
        return eleveRepository.findAllByActive(true).stream().map(eleveMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(EleveDTO entityDTO) {
        Eleve eleve = eleveRepository.findByMatricule(entityDTO.getMatricule());
        eleve.setActive(false);
        eleveRepository.save(eleve);
    }

    @Override
    public Eleve findByMatricule(String matricule) {
        return eleveRepository.findByMatricule(matricule);
    }
}