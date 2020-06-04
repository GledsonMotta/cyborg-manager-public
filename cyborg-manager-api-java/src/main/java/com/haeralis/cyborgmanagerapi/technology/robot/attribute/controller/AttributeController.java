package com.haeralis.cyborgmanagerapi.technology.robot.attribute.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.cfg.beanvalidation.IntegrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haeralis.cyborgmanagerapi.technology.robot.attribute.model.Attribute;
import com.haeralis.cyborgmanagerapi.technology.robot.attribute.repository.AttributeRepository;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@RestController
@RequestMapping("/attributes")
@CrossOrigin("${external-origin}")
public class AttributeController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private AttributeRepository attributeRepository;
	
	/**
	 * Retorna lista de atributos
	 * @return List<Attribute>
	 */
	@GetMapping
	public List<Attribute> listAll(){			
		return attributeRepository.findAll();
	}
			
	/**
	 * Busca um atributo
	 * @param id a ser buscado
	 * @return atributo encontrado
	 */
	@GetMapping(path="/{id}")
	public ResponseEntity<Attribute> search(@PathVariable Long id){
		return attributeRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	/*@GetMapping(path="/{id}")
	public Optional<Attribute> search(@PathVariable Long id){
		return attributeRepository.findById(id);
	}*/
	
	/**
	 * Adiciona novo atributo
	 * @param attribute a ser adicionado
	 */
	@PostMapping
	public void add(@RequestBody Attribute attribute){
		
		List<Attribute>	search = attributeRepository.findByName(attribute.getName());
		
		if(search!=null && search.size()>0) {
			throw new IllegalArgumentException("This attribute name is already in use");
		}
		attributeRepository.save(attribute);		
	}
	
	/**
	 * Atualiza atributo
	 * @param attribute a ser atualizado
	 */
	@PutMapping
	public void update(@RequestBody Attribute attribute){
		attributeRepository.save(attribute);	
	}
	
	/**
	 * Deleta um atributo
	 * @param id a ser excluído
	 * @throws Exception 
	 */
	@DeleteMapping(path="{id}")
	public void delete(@PathVariable Long id) throws Exception{
		try {
			attributeRepository.deleteById(id);	
		}
		catch(Exception ce) {
			log.error("Error while deleting attribute: "+ce.getMessage());
			throw new IntegrationException("This attribute cannot be deleted, because it's been used already!");			
		}
	}
}
