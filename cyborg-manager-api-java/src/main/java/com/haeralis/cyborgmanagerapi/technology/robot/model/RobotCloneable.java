package com.haeralis.cyborgmanagerapi.technology.robot.model;

/**
 * Interface to be implemented by classes that can be cloned
 * @author Haeralis (GledsonMotta)
 *
 */
public interface RobotCloneable extends Cloneable{
	
	public abstract Long getOriginalId();
	public abstract Double getOriginalVersion();
	public abstract Double getVersion();	
}
