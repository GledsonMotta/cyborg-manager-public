package com.haeralis.cyborgmanagerapi.technology.robot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@Data
@Entity
//@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class RobotModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
}
