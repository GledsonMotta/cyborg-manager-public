package com.haeralis.cyborgmanagerapi.technology.robot.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haeralis.cyborgmanagerapi.technology.robot.model.Robot;
import com.haeralis.cyborgmanagerapi.technology.robot.repository.RobotRepository;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@RestController
@RequestMapping("/robot")
@CrossOrigin("${external-origin}")
public class RobotController {
	
	Logger log = Logger.getLogger(this.getClass()); 
	
	@Autowired
	private RobotRepository robotRepository;
			
	/**
	 * Retorna lista de atributos
	 * @return List<Attribute>
	 */
	@GetMapping
	public List<Robot> listAll(){			
		return robotRepository.findAllByOrderByIdAscVersionAsc();
	}
	
	/**
	 * Retorna lista de modelos default
	 * @return List<Robot>
	 */
	@GetMapping("/originals")
	public List<Robot> listOriginals(){
		return robotRepository.findByOriginalIdIsNull();
	}
		
}
