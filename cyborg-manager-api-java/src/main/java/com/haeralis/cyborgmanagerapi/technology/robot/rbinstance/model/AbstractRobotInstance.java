package com.haeralis.cyborgmanagerapi.technology.robot.rbinstance.model;

import javax.persistence.Inheritance;

import com.haeralis.cyborgmanagerapi.technology.robot.util.RobotConstants;

import lombok.Data;

/**
 * Abstract class for Robot
 * @author Haeralis (GledsonMotta)
 *
 */
@Data
@Inheritance
public abstract class AbstractRobotInstance {

	public static final Long MAXIMUM_HUMAN_ENERGY = 8000L;
	public static final Long MAXIMUM_HUMAN_DAMAGE = 8000L;
	
	public AbstractRobotInstance() {
		this.setTotalEnergy(MAXIMUM_HUMAN_ENERGY);
		this.setTotalDamage(MAXIMUM_HUMAN_DAMAGE);
		//this.setPercentEnergy(RobotConstants.MAXIMUM_ENERGY_PERCENT);
		//this.setPercentDamage(RobotConstants.MINIMUM_DAMAGE_PERCENT);
	}
	//Energia total em Watts
		private Long totalEnergy;
		//Representa a capacidade total em receber dano
		private Long totalDamage;
		private Double energyPct;
		private Double damagePct;
							
		/**
		 * @param energyPct O percentEnergy a ser setado.
		 */	
		public void setEnergyPct(Double energyPct) {
			if(!(energyPct>RobotConstants.MAXIMUM_ENERGY_PERCENT||energyPct<RobotConstants.MINIMUM_ENERGY_PERCENT)) {
				this.energyPct = energyPct;
			}
			else{
				throw new IllegalArgumentException(RobotConstants.INVALID_ENERGY_ARGUMENT);
			}
		}
		
		/**
		 * @param damagePct O percentDamage a ser setado.
		 */
		public void setDamagePct(Double damagePct) {
			if(!(damagePct>RobotConstants.MAXIMUM_DAMAGE_PERCENT||damagePct<RobotConstants.MINIMUM_DAMAGE_PERCENT)) {
				this.damagePct = damagePct;
			}
			else{
				throw new IllegalArgumentException(RobotConstants.INVALID_DAMAGE_ARGUMENT);
			}
		}	
			
		public void takeDamage(Long damage) {
			this.setTotalDamage(this.getTotalDamage()-damage);
			recalculateDamagePercent();
		}

		
		public void takeEnergy(Long energy) {
			this.setTotalEnergy(this.getTotalEnergy()-energy);	
			recalculateEnergyPercent();
		}
		
		/**
		 * Método para recalcular percentual de dano
		 */
		private void recalculateDamagePercent() {
			Double damagePercent = RobotConstants.MAXIMUM_DAMAGE_PERCENT 
					- (double) ((MAXIMUM_HUMAN_DAMAGE-this.getTotalDamage())/MAXIMUM_HUMAN_DAMAGE*100);		
			this.setDamagePct(damagePercent);
		}
		
		/**
		 * Método para recalcular percentual de dano
		 */
		private void recalculateEnergyPercent() {
			Double energyPercent = RobotConstants.MAXIMUM_ENERGY_PERCENT 
					- (double) ((MAXIMUM_HUMAN_ENERGY-this.getTotalDamage())/MAXIMUM_HUMAN_ENERGY*100);		
			this.setEnergyPct(energyPercent);
		}
	}
