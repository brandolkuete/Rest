package com.brandolkuete.ScolarWebRest.service.serviceImpl;

import com.brandolkuete.ScolarWebRest.dto.EnseignantDTO;
import com.brandolkuete.ScolarWebRest.dto.mapper.EnseignantMapper;
import com.brandolkuete.ScolarWebRest.entities.Enseignant;
import com.brandolkuete.ScolarWebRest.repository.EnseignantRepository;
import com.brandolkuete.ScolarWebRest.service.EnseignantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnseignantServiceIml implements EnseignantService {

    private final EnseignantRepository enseignantRepository;
    private final EnseignantMapper enseignantMapper;

    public EnseignantServiceIml(EnseignantRepository enseignantRepository, EnseignantMapper enseignantMapper) {
        this.enseignantRepository = enseignantRepository;
        this.enseignantMapper = enseignantMapper;
    }

    @Override
    public Enseignant findByTelephone(String telephone) {
        return enseignantRepository.findByTelephone(telephone);
    }

    @Override
    public EnseignantDTO save(EnseignantDTO entityDTO) {
       final Enseignant enseignant = enseignantMapper.toEntity(entityDTO);
        return enseignantMapper.toDto(enseignantRepository.save(enseignant));
    }

    @Override
    public EnseignantDTO update(EnseignantDTO entityDTO) {
        Enseignant enseignant= enseignantRepository.findByTelephone(entityDTO.getTelephone());
       Enseignant enseignant1 = enseignantRepository.findByTelephone(entityDTO.getTelephone());
       enseignant.setId(enseignant1.getId());

       enseignant = enseignantRepository.save(enseignant);
        return enseignantMapper.toDto(enseignant);
    }

    @Override
    public List<EnseignantDTO> findAll() {
        return enseignantRepository.findAllByActive(true).stream().map(enseignantMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(EnseignantDTO entityDTO) {
       Enseignant enseignant = enseignantRepository.findByTelephone(entityDTO.getTelephone());
       enseignant.setActive(false);
       enseignantRepository.save(enseignant);
    }
}
