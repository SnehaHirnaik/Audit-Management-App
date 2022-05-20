package com.mfpe.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ProjectManagerTest {
	
	@Mock
	static ProjectManager projectManager;
	
	@BeforeAll
	public static void  setUp() throws Exception{
		projectManager = new ProjectManager();
		projectManager.setId(1);
		projectManager.setName("Sneha Hirnaik");
		projectManager.setUsername("sneha");
		projectManager.setPassword("sneha@1");
		projectManager.setProjectName("Project-1");
		
	}
	
	@Test
	public void testGetters() {
		assertEquals("sneha", projectManager.getUsername());
	}
	
	@Test
	public void testSetters() {
		projectManager.setName("Sneha");
		assertEquals("Sneha", projectManager.getName());		
	}
	
	@Test
	public void testToString() {
		assertEquals("ProjectManager(id=" + projectManager.getId() + ", name=" + projectManager.getName() + ", username=" + projectManager.getUsername() + ", password=" + projectManager.getPassword()
				+ ", projectName=" + projectManager.getProjectName() + ")",projectManager.toString());
	}

}
