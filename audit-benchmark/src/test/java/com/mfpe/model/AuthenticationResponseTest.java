package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthenticationResponseTest {

	@Mock
	AuthenticationResponse authenticationResponse;

	@Test
	public void testMethods() {
		authenticationResponse = new AuthenticationResponse();
		
		authenticationResponse.setName("Pod1");
		authenticationResponse.setProjectName("Project-1");
		authenticationResponse.setValid(true);
		assertNotNull(authenticationResponse);
		assertEquals("Pod1", authenticationResponse.getName());
		assertEquals("Project-1", authenticationResponse.getProjectName());
		assertEquals("AuthenticationResponse(name=" + authenticationResponse.getName() + ", projectName="
				+ authenticationResponse.getProjectName() + ", isValid=" + authenticationResponse.isValid() + ")",
				authenticationResponse.toString());
	}

}
