package com.mfpe.exception;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProjectManagerNotFoundExceptionTest {
	
	@Mock
	private ProjectManagerNotFoundException projectManagerNotFoundException;
	
	
	@Test
	public void testOneArgConstructor() {
		ProjectManagerNotFoundException projectManagerNotFoundException = new ProjectManagerNotFoundException("Project Manager not found.");
		assertEquals("Project Manager not found.", projectManagerNotFoundException.getMessage());
	}
	
	@Test
	public void testNoArgsConstructor() {
		ProjectManagerNotFoundException projectManagerNotFoundException = new ProjectManagerNotFoundException();
		assertEquals(null, projectManagerNotFoundException.getMessage());
	}

}
