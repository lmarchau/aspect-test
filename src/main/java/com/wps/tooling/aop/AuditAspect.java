package com.wps.tooling.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

	@Around(value = "@annotation(com.wps.tooling.annotation.Demo)")
	public Object pageableMethod(ProceedingJoinPoint pjp) throws Throwable {
		return true;
	}

}
