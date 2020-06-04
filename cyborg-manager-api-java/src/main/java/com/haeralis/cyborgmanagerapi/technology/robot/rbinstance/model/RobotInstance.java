package com.haeralis.cyborgmanagerapi.technology.robot.rbinstance.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.haeralis.cyborgmanagerapi.technology.robot.util.RobotConstants;

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
public class RobotInstance extends AbstractRobotInstance implements RobotInstanceCloneable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String name;	
	private LocalDate activDate;	
	private LocalDate deactivDate;		
		
	//@OneToMany(mappedBy="robotInstanceId", cascade=CascadeType.ALL)
	@Transient
	private List<InstanceAttribute> additional;
	
	/*@ManyToOne
	@JoinColumn(name="robot_id")
	private Robot robot;*/
	
	private Long robotId;
	
	{
		this.additional = new ArrayList<>();
	}
			
	/**
	 * Estabelece novo clone Cyberpunk
	 * 
	 * @param name o Novo nome do clone
	 * @param extraAdditional Adicionais extras a serem atribuidos ao clone
	 * @return um novo clone de CyberpunkHumanRobot
	 * @throws CloneNotSupportedException
	 */
	public RobotInstance getNewClone(String name,  List<InstanceAttribute> extraAdditional) throws CloneNotSupportedException {
		
		RobotInstance clone = (RobotInstance) super.clone();
		clone.setId(null);
		//clone.setOriginalId(this.id);
		//clone.setVersion(version);
		clone.setName(name);
		clone.setEnergyPct(Math.random()*RobotConstants.MAXIMUM_ENERGY_PERCENT);
		clone.setDamagePct(Math.random()*RobotConstants.MAXIMUM_ENERGY_PERCENT/2);
		/*if(!(age>CyberpunkConstants.MAXIMUM_CLONE_AGE||age<CyberpunkConstants.MINIMUM_CLONE_AGE)) {	
			clone.setAge(age);
		}
		else{
			throw new IllegalArgumentException(CyberpunkConstants.INVALID_AGE_ARGUMENT);
		}*/
		clone.setActivDate(LocalDate.now());
		clone.addAdditional(extraAdditional);
				
		return clone;
	}

	/**
	 * @param additional O atributo extra a ser adicionado.
	 */
	public void addAdditional(List<InstanceAttribute> extraAdditional) {
		this.additional.addAll(extraAdditional);
	}
	
	/**
	 * @return Retorna o atributo id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id O id a ser setado.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	

	/**
	 * @return Retorna o atributo percentEnergy
	 */
	@Override
	public Double getEnergyPct() {
		//Override and simulate energy consumed
		return Math.random()*RobotConstants.MAXIMUM_ENERGY_PERCENT;
	}


	/**
	 * @return Retorna o atributo percentDamage
	 */
	@Override
	public Double getDamagePct() {
		//Override and simulate damage taken
		return Math.random()*RobotConstants.MAXIMUM_DAMAGE_PERCENT/2;
	}	
}
