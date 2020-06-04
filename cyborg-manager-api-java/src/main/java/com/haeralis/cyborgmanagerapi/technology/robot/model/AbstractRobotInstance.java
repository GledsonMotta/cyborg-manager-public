package com.haeralis.cyborgmanagerapi.technology.robot.model;

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

	//Energia total em Watts
		private Long totalEnergy;
		//Representa a capacidade total em receber dano
		private Long totalDamage;
		private Double energyPct;
		private Double damagePct;
		
			
		/**
		 * Método abstrato para definição de recebimento de dano
		 * @param damage o dano absorvido
		 */
		public abstract void takeDamage(Long damage);
		
		/**
		 * Método abstrato para definição de consumo de energia
		 * @param energy a energia consumida
		 */
		public abstract void takeEnergy(Long energy);
			
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
	}
