package dev.gabrieljbo.project.commons.aspects;

import javax.validation.ConstraintViolationException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import dev.gabrieljbo.project.commons.exception.SystemErrorCode;
import dev.gabrieljbo.project.commons.exception.SystemException;

@Aspect
@Component
public class ExceptionHandlerAspect {

	@Pointcut("@annotation(HandleExceptions)")
	public void executionPoint() {
	}

	@Around(value = "executionPoint()")
	public Object handleException(ProceedingJoinPoint joinPoint) {
		Object result = null;

		try {
			result = joinPoint.proceed();
		} catch (DataAccessException ex) {
			throw new SystemException(ex, SystemErrorCode.DATA_ACCESS_ERROR_CODE);
		} catch (ConstraintViolationException ex) {
			throw new SystemException(ex, SystemErrorCode.VALIDATION_ERROR_CODE);
		} catch (SystemException ex) {
			throw ex;
		} catch (Throwable ex) {
			throw new SystemException(ex, SystemErrorCode.UNHANDLED_ERROR_CODE);
		}

		return result;
	}

}