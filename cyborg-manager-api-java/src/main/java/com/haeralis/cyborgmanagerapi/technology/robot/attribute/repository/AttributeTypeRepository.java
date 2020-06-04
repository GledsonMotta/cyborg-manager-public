package com.haeralis.cyborgmanagerapi.technology.robot.attribute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haeralis.cyborgmanagerapi.technology.robot.attribute.model.AttributeType;

/**
 * Simulador de repositório para tipos de Atributos
 * @author Haeralis (GledsonMotta)
 *
 */
public interface AttributeTypeRepository extends JpaRepository<AttributeType, Integer> {

	List<AttributeType> findByName(String name);
}
