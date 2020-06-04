package com.haeralis.cyborgmanagerapi.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.haeralis.cyborgmanagerapi.CyborgManagerApiApplicationTests;
import com.haeralis.cyborgmanagerapi.technology.robot.attribute.controller.AttributeController;
import com.haeralis.cyborgmanagerapi.technology.robot.attribute.model.Attribute;

/**
 * Test class for AttributeController
 * @author Haeralis (GledsonMotta)
 *
 */
@Transactional
public class AttributeControllerTest extends CyborgManagerApiApplicationTests {
	
	@Autowired
	AttributeController attributeController;
		
	@Test
    public void testListAll() {

        List<Attribute> list = attributeController.listAll();

        Assertions.assertNotNull(list,"failure - expected not null");
        Assertions.assertFalse(list.isEmpty(),"failure - expected not empty");
    }
	
		 	
	@Test
    public void testSearch() {

		//Attribute attr = new Attribute();
		//attr.setCode(1L);
		
		//attr = attributeController.search(attr);

       // Assert.assertNotNull("failure - expected not null", attr);
    } 	
	
	/*@Test
    public void testAdd() {

		Attribute attr = new Attribute();
		attr.setCode(100L);
		attr.setName("TESTING");
		attr.setAttributeType(new AttributeType());
		attr.getAttributeType().setCode(1);
		
		attributeController.add(attr);
    } 	*/
	
	@Test
    public void testUpdate() {

		/*Attribute attr = new Attribute();
		attr.setCode(1L);
		attr.setName("TESTING UPDATE");
		attr.setAttributeType(new AttributeType());
		attr.getAttributeType().setCode(1);
		
		attributeController.update(attr);*/
    } 	
	
	@Test
    public void testDelete() throws Exception {

		/*Attribute attr = new Attribute();
		attr.setCode(1L);
		
		attributeController.delete(attr.getCode());*/
    } 	
}
