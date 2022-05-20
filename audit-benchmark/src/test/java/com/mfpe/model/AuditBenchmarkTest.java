package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuditBenchmarkTest {
	
	@Mock
	AuditBenchmark auditBenchmark;
	
	@Test
	public void testMethods() {
		auditBenchmark = new AuditBenchmark();
		auditBenchmark.setBenchmarkId(1);
		auditBenchmark.setAuditType("Internal");
		auditBenchmark.setBenchmarkNoAnswers(3);
		assertNotNull(auditBenchmark);
		assertEquals("Internal",auditBenchmark.getAuditType());
		assertEquals("AuditBenchmark(benchmarkId=" + auditBenchmark.getBenchmarkId() + ", auditType=" + auditBenchmark.getAuditType() + ", benchmarkNoAnswers="
				+ auditBenchmark.getBenchmarkNoAnswers() + ")",auditBenchmark.toString());
	}

}
