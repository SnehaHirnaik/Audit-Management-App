package com.mfpe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.mfpe.model.AuthenticationRequest;
import com.mfpe.model.AuthenticationResponse;
import com.mfpe.model.ProjectManager;
import com.mfpe.model.ProjectManagerDetails;
import com.mfpe.service.JwtService;
import com.mfpe.service.ProjectManagerDetailsService;

@ExtendWith(MockitoExtension.class)

public class AuthControllerTest {

	@Mock
	private AuthenticationManager authenticationManager;

	@Mock
	private ProjectManagerDetailsService projectManagerDetailsService;

	@Mock
	private JwtService jwtService;

	@InjectMocks
	private AuthController authController;

	@Test // for '/authenticate'
	public void generateJwtTest() {

		AuthenticationRequest request = null;
		request = new AuthenticationRequest();
		ResponseEntity<String> response = null;
		ProjectManagerDetails projectManagerDetails = null;
		ProjectManager projectManager = null;
		request.setUsername("pod1");
		request.setPassword("pod1@123");

		projectManager = new ProjectManager(1, "pod1", "pod1", "pod1@123", "Project1");
		projectManagerDetails = new ProjectManagerDetails(projectManager);

		final String jwtToken = "jj.ww.tt";

		response = new ResponseEntity<String>(jwtToken, HttpStatus.OK);

		// the correct flow
		when(authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())))
				.thenReturn(null);
		when(projectManagerDetailsService.loadUserByUsername(request.getUsername())).thenReturn(projectManagerDetails);
		when(jwtService.generateToken(projectManagerDetails)).thenReturn(jwtToken);
		assertEquals(response, authController.generateJwt(request));
		assertEquals( "jj.ww.tt",jwtService.generateToken(projectManagerDetails));
		

		// authenticating incorrect credentials
		request = new AuthenticationRequest();
		request.setUsername("invalidUser1");
		request.setPassword("pod1@123");

		projectManager = null;
		projectManagerDetails = null;
		response = new ResponseEntity<String>("Not Authorized Project Manager", HttpStatus.FORBIDDEN);

		// the wrong flow
		when(authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())))
				.thenReturn(null);
		when(projectManagerDetailsService.loadUserByUsername(request.getUsername())).thenThrow(RuntimeException.class);
		assertEquals(response, authController.generateJwt(request));
	}

	@Test // for '/validate'
	public void validateJwt() {
		// instances req.
		String jwtTokenHeader = "Bearer jj.ww.tt";
		AuthenticationResponse authenticationResponse = null;
		ResponseEntity<AuthenticationResponse> response = null;
		ProjectManagerDetails projectManagerDetails = null;
		ProjectManager projectManager = null;

		projectManager = new ProjectManager(1, "pod1", "pod1", "pod1@123", "Project1");
		projectManagerDetails = new ProjectManagerDetails(projectManager);

		authenticationResponse = new AuthenticationResponse("pod1", "Project1", true);

		String jwtToken = jwtTokenHeader.substring(7);
		String username = "pod1";
		response = new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);

		// validate jwt token
		when(jwtService.extractUsername(jwtToken)).thenReturn(username);
		when(projectManagerDetailsService.loadUserByUsername(username)).thenReturn(projectManagerDetails);
		when(jwtService.validateToken(jwtToken, projectManagerDetails)).thenReturn(true); // success
		assertEquals(response, authController.validateJwt(jwtTokenHeader));

		// validate incorrect jwt token
		jwtTokenHeader = "Bearer jj.wrong.tt";

		projectManager = null;
		projectManagerDetails = null;
		authenticationResponse = new AuthenticationResponse("Invalid", "Invalid", false);
		username = "";
		jwtToken = jwtTokenHeader.substring(7);
		response = new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);

		when(jwtService.extractUsername(jwtToken)).thenReturn(username);
		when(projectManagerDetailsService.loadUserByUsername(username)).thenReturn(projectManagerDetails);
		when(jwtService.validateToken(jwtToken, projectManagerDetails)).thenReturn(false); // wrong
		assertEquals(response, authController.validateJwt(jwtTokenHeader));

	}
}
