package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthenticationResponseTest {
	
	@Mock
	AuthenticationResponse authenticationResponse;
	
	@Test
	public void authRes() {
		authenticationResponse = new AuthenticationResponse("Sneha", "Project", false);
		assertEquals("AuthenticationResponse(name=" + authenticationResponse.getName() + ", projectName=" + authenticationResponse.getProjectName() + ", isValid=" + authenticationResponse.isValid() + ")", authenticationResponse.toString());
	}

}
