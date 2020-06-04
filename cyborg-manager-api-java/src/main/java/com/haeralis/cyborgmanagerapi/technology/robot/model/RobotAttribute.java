package com.haeralis.cyborgmanagerapi.technology.robot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.haeralis.cyborgmanagerapi.technology.robot.attribute.model.Attribute;

import lombok.Data;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@Data
@Entity
public class RobotAttribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private Long robotId;
	@OneToOne
	@JoinColumn(name="attribute_id")
	private Attribute attribute;	
}
