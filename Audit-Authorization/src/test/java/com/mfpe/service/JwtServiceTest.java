package com.mfpe.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class JwtServiceTest {

	@Mock
	JwtService jwtService;
	
	@Test
	public void testJwtService() {
		assertThrows(NullPointerException.class, ()-> jwtService.extractUsername("abc.aeraedrf.aefraefae"));
		
		
	}
}
