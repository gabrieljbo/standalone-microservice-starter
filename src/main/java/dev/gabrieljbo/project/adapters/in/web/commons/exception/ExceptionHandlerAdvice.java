package dev.gabrieljbo.project.adapters.in.web.commons.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;

import dev.gabrieljbo.project.adapters.in.web.commons.model.Response;
import dev.gabrieljbo.project.adapters.in.web.commons.model.ResponseError;
import dev.gabrieljbo.project.adapters.in.web.commons.model.Status;
import dev.gabrieljbo.project.commons.exception.ErrorCode;
import dev.gabrieljbo.project.commons.exception.SystemException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	private static final Marker errorHasOcurredMarker = MarkerFactory.getMarker("ERROR_HAS_OCURRED");

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<Response<HashMap<String, String>>> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, WebRequest request) {
		log.error(errorHasOcurredMarker, StringUtils.EMPTY, ex);

		Response<HashMap<String, String>> response = new Response<>();
		response.setStatus(Status.ERROR);
		response.setData(new HashMap<>(0));
		response.setErrors(new ArrayList<>(0));

		for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
			FieldError fieldError = (FieldError) objectError;

			ResponseError responseError = new ResponseError();
			responseError.setCode(fieldError.getField());
			responseError.setMessage(fieldError.getDefaultMessage());

			response.getErrors().add(responseError);
		}

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Response<HashMap<String, String>>> handleConstraintViolationException(
			ConstraintViolationException ex, WebRequest request) {
		log.error(errorHasOcurredMarker, StringUtils.EMPTY, ex);

		Response<HashMap<String, String>> response = new Response<>();
		response.setStatus(Status.ERROR);
		response.setData(new HashMap<>(0));
		response.setErrors(new ArrayList<>(0));

		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			ResponseError responseError = new ResponseError();
			responseError.setCode(violation.getPropertyPath().toString());
			responseError.setMessage(violation.getMessage());

			response.getErrors().add(responseError);
		}

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ SystemException.class })
	public ResponseEntity<Response<HashMap<String, String>>> handleSystemException(SystemException ex, WebRequest request,
			HandlerMethod handlerMethod) {
		log.error(errorHasOcurredMarker, StringUtils.EMPTY, ex);

		Response<HashMap<String, String>> response = new Response<>();
		response.setStatus(Status.ERROR);
		response.setData(new HashMap<>(0));
		response.setErrors(new ArrayList<>(0));

		for (ErrorCode errorCode : ex.getErrorCodes()) {
			ResponseError responseError = new ResponseError();
			responseError.setCode(String.valueOf(errorCode.getCode()));
			responseError.setMessage(messageSource.getMessage(String.valueOf(errorCode.getCode()), null, Locale.getDefault()));

			response.getErrors().add(responseError);
		}
		
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}

}