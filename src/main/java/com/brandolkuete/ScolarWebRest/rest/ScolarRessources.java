package com.brandolkuete.ScolarWebRest.rest;

import java.util.List;

import com.brandolkuete.ScolarWebRest.dto.mapper.EleveMapper;
import com.brandolkuete.ScolarWebRest.dto.mapper.EnseignantMapper;
import com.brandolkuete.ScolarWebRest.service.serviceImpl.EleveServiceImpl;
import com.brandolkuete.ScolarWebRest.service.serviceImpl.EnseignantServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.brandolkuete.ScolarWebRest.dto.EleveDTO;
import com.brandolkuete.ScolarWebRest.dto.EnseignantDTO;
import com.brandolkuete.ScolarWebRest.dto.ReponseDto;
import com.brandolkuete.ScolarWebRest.entities.Eleve;
import com.brandolkuete.ScolarWebRest.entities.Enseignant;


@RestController
@RequestMapping("/systemescolaire/api")
@CrossOrigin(origins="http://localhost:4200")
public class ScolarRessources {

	private final EleveServiceImpl eleveService;
	private final EnseignantServiceIml enseignantServiceIml;
	private final EleveMapper eleveMapper;
	private final EnseignantMapper enseignantMapper;


	public ScolarRessources(EleveServiceImpl eleveService, EnseignantServiceIml enseignantServiceIml, EleveMapper eleveMapper, EnseignantMapper enseignantMapper) {
		this.eleveService = eleveService;
		this.enseignantServiceIml = enseignantServiceIml;
		this.eleveMapper = eleveMapper;
		this.enseignantMapper = enseignantMapper;
	}

	@RequestMapping(value= "/enregistrerEleve", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public ReponseDto enregistrerEleve(@RequestBody EleveDTO eleveDto) {
    	
    	if(eleveService.findByMatricule(eleveDto.getMatricule())!=null) {
    		return new ReponseDto(0, "Un eleve existe deja avec ce matricule");
    	}else {
    		EleveDTO eleve = eleveService.save(eleveDto);

    		if(eleve== null) {
    			return new ReponseDto(0, "Echec survenu lors de l'enregistrement");
    		}else {
    			return new ReponseDto(1, "Enregistrement réussi");
    		}
    	}
    }
    
    @RequestMapping(value= "/enregistrerEnseignant", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public ReponseDto enregistrerEnseignant(@RequestBody EnseignantDTO enseignDto) {
    	
    	if(enseignantServiceIml.findByTelephone(enseignDto.getTelephone())!=null) {
    		return new ReponseDto(0, "Un enseignant existe deja avec ce numero de telephone");
    	}else {
    		
    		EnseignantDTO enseig= enseignantServiceIml.save(enseignDto);
    		
    		if(enseig== null) {
    			return new ReponseDto(0, "Echec survenu lors de l'enregistrement");
    		}else {
    			return new ReponseDto(1, "Enregistrement réussi");
    		}
    	}
    }
    
    @RequestMapping(value= "/listeEleve", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<EleveDTO> listeElves(){
    	return eleveService.findAll();
    }
    
    @RequestMapping(value= "/listeEnseignant", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<EnseignantDTO> listeEnseignants(){
    	return enseignantServiceIml.findAll();
    }
    
    @RequestMapping(value= "/rechercherEleve/{matricule}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public EleveDTO rechercherEleve(@PathVariable String matricule) {
    	
    	Eleve eleve= eleveService.findByMatricule(matricule);
    	
    	EleveDTO eleveDto= new EleveDTO();
    	
    	if(eleve==null) {
    		return eleveDto;
    	}else {

    		eleveDto = eleveMapper.toDto(eleve);
    		return eleveDto;
    	}
    	
    }
    
    @RequestMapping(value= "/rechercherEnseignant/{telephone}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public EnseignantDTO rechercherEnseignant(@PathVariable String telephone) {
    	
    	Enseignant enseign= enseignantServiceIml.findByTelephone(telephone);
    	
    	EnseignantDTO enseignDto= new EnseignantDTO();
    	
    	if(enseign==null) {
    		return enseignDto;
    	}else {
    		enseignDto = enseignantMapper.toDto(enseign);
    		return enseignDto;
    	}
    	
    }

    @RequestMapping(value = "/modifierEnseignant", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public EnseignantDTO modifierEnseignant(@RequestBody EnseignantDTO enseignantDTO){
		if(enseignantServiceIml.findByTelephone(enseignantDTO.getTelephone())!=null) {
			return enseignantServiceIml.update(enseignantDTO);
		}else {
			return enseignantServiceIml.save(enseignantDTO);
		}
	}

	@RequestMapping(value = "/modifierEleve", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public EleveDTO modifierEleve(@RequestBody EleveDTO eleveDto){
		return eleveService.update(eleveDto);
	}

	@RequestMapping(value = "/supprimerEleve", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void supprimerEleve(@RequestBody EleveDTO eleveDTO){
		eleveService.delete(eleveDTO);
	}

	@RequestMapping(value = "/supprimerEnseignant", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void supprimerEnseignant(@RequestBody EnseignantDTO enseignantDTO){
		enseignantServiceIml.delete(enseignantDTO);
	}
}