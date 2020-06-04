package com.haeralis.cyborgmanagerapi.technology.robot.rbinstance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haeralis.cyborgmanagerapi.technology.robot.rbinstance.model.RobotInstance;

/**
 * Repository simulator for Cyberpunk Model
 * @author Haeralis (GledsonMotta)
 *
 */
public interface RobotInstanceRepository extends JpaRepository<RobotInstance, Long> {
	
	List<RobotInstance> findAllByOrderByIdAscActivDateAsc();
	
	Optional<RobotInstance> findById(Long id);
	
	List<RobotInstance> findByName(String name);
	
	List<RobotInstance> findByNameAndIdNot(String name, Long id);
	
	List<RobotInstance> findByIdNotNull();
	
	List<RobotInstance> findByRobotId(Long id);
		
	//RobotInstance findTopByOriginalIdOrderByVersionDesc(Long parentId);
}
