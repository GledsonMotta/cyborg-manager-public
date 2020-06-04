package com.haeralis.cyborgmanagerapi.technology.robot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haeralis.cyborgmanagerapi.technology.robot.model.Robot;

/**
 * Repository simulator for Cyberpunk Model
 * @author Haeralis (GledsonMotta)
 *
 */
public interface RobotRepository extends JpaRepository<Robot, Long> {
	
	List<Robot> findAllByOrderByIdAscVersionAsc();
	
	Optional<Robot> findById(Long id);
	
	//List<Robot> findByparentId(Long parentId);
	
	List<Robot> findByName(String name);
	
	List<Robot> findByNameAndIdNot(String name, Long id);
	
	List<Robot> findByIdNotNull();
	
	List<Robot> findByOriginalIdIsNull();
	
	//List<Robot> findByParentIdNotNullOrderByIdAscParentIdAscVersionAsc();
	
	//Robot findTopByParentIdOrderByVersionDesc(Long parentId);
}
