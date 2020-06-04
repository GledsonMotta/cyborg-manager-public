package com.haeralis.cyborgmanagerapi.technology.robot.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@Getter
@Setter
@Entity
//@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Robot implements RobotCloneable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long originalId; 
	private Double originalVersion;
	private String name;	
	private LocalDate birthDateDef;	
	private Double version;
	@OneToOne
	@JoinColumn(name="robot_model_id")
	private RobotModel rbModel;		
	@OneToOne
	@JoinColumn(name="robot_type_id")
	private RobotType rbType;		
	@OneToOne
	@JoinColumn(name="robot_nature_id")
	private RobotNature rbNature;	
	
	//@OneToMany(mappedBy="robotId", cascade=CascadeType.ALL)
	@Transient
	private List<RobotAttribute> additional;
	
	{
		this.additional = new ArrayList<>();
	}
			
	/**
	 * Estabelece novo clone Cyberpunk
	 * 
	 * @param name o Novo nome do clone
	 * @param age A idade do clone
	 * @param A versão a ser clonada
	 * @param extraAdditional Adicionais extras a serem atribuidos ao clone
	 * @return um novo clone de CyberpunkHumanRobot
	 * @throws CloneNotSupportedException
	 */
	public Robot getNewClone(String name, int age, Double version,  List<RobotAttribute> extraAdditional) throws CloneNotSupportedException {
		
		Robot clone = (Robot) super.clone();
		clone.setId(null);
		//clone.setParentId(this.id);
		clone.setVersion(version);
		clone.setName(name);
				
		clone.setBirthDateDef(LocalDate.now());
		clone.addAdditional(extraAdditional);
				
		return clone;
	}

	/**
	 * @param additional O atributo extra a ser adicionado.
	 */
	public void addAdditional(List<RobotAttribute> extraAdditional) {
		this.additional.addAll(extraAdditional);
	}	
}
