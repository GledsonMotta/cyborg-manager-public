package com.haeralis.cyborgmanagerapi.technology.robot.attribute.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haeralis.cyborgmanagerapi.technology.robot.attribute.model.AttributeType;
import com.haeralis.cyborgmanagerapi.technology.robot.attribute.repository.AttributeTypeRepository;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@RestController
@RequestMapping("/attribute-types")
@CrossOrigin("${external-origin}")
public class AttributeTypeController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private AttributeTypeRepository attributeTypeRepository;
			
	/**
	 * Retorna lista de tipos de tipos de atributos
	 * @return List<Attribute>
	 */
	@GetMapping()
	public List<AttributeType> listAllType(){		
		return attributeTypeRepository.findAll();
	}
	
	/**
	 * Busca um tipo de atributo
	 * @param id a ser buscado
	 * @return atributo encontrado
	 * @throws Exception 
	 */
	@GetMapping(path="{id}")
	public Optional<AttributeType> search(@PathVariable Integer id) throws Exception {	
		
		return attributeTypeRepository.findById(id);
	}		
	
	/**
	 * Adiciona novo tipo de atributo
	 * @param attributeType a ser adicionado
	 */
	@PostMapping
	public void add(@RequestBody AttributeType attributeType){
		
		List<AttributeType>	search = attributeTypeRepository.findByName(attributeType.getName());
		
		if(search!=null && search.size()>0) {
			throw new IllegalArgumentException("This attribute type name is already in use");
		}
		attributeTypeRepository.save(attributeType);		
	}
}
