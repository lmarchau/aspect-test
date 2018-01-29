package com.wps.tooling.aop;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.wps.tooling.annotation.Demo;

public class AuditAspectTest {

	private AuditAspect auditAspect = new AuditAspect();

	private AspectJProxyFactory factory;

	@Before
	public void before() {
		factory = new AspectJProxyFactory(new InternalService());
		factory.addAspect(auditAspect);
	}

	@Test
	public void shouldSuccess() {
		Assertions.assertThat(((InternalService)factory.getProxy()).shouldSuccess()).isTrue();
	}

	@Test
	public void shouldFail() {
		Assertions.assertThat(((InternalService)factory.getProxy()).shouldFail()).isFalse();
	}

	private class InternalService {

		@Demo
		public boolean shouldSuccess() {
			return false;
		}

		public boolean shouldFail() {
			return false;
		}

	}


}
