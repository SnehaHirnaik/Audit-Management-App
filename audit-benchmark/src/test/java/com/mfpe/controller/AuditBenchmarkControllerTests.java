package com.mfpe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfpe.model.AuditBenchmark;
import com.mfpe.service.AuditBenchmarkService;
import com.mfpe.service.AuthorizationService;

@SpringBootTest
class AuditBenchmarkControllerTests {
	
	@Mock
	AuditBenchmarkService auditBenchmarkService;
	
	@Mock
	AuthorizationService authorizationService;
	
	@InjectMocks
	AuditBenchmarkController controller;
	
	
	
	@Test
	public void contextLoads() throws Exception {
		assertNotNull(controller);
	}
	
	@Test
	public void testHealthCheck() {
		assertEquals("Audit Benchmark Microservice is Active",controller.healthCheck());
	}
	
	@Test
	public void testGetAuditBenchmark() throws Exception{
		List<AuditBenchmark> auditBenchmarkList = new ArrayList<>();
		auditBenchmarkList.add(new AuditBenchmark(1,"Internal",3));
		auditBenchmarkList.add(new AuditBenchmark(2,"SOX",1));
		
		when(authorizationService.validateJwt("jwt")).thenReturn(true);
		
		when(auditBenchmarkService.getAuditBenchmarkList()).thenReturn(auditBenchmarkList);
		
		assertEquals(auditBenchmarkList, controller.getAuditBenchmark("jwt"));
		
		assertNotNull(controller.getAuditBenchmark("jwt"));
		
		//List<AuditBenchmark> abList = controller.getAuditBenchmark("");
		assertNotSame(controller.getAuditBenchmark("jwt"),controller.getAuditBenchmark(""));
		
	}
	
}
