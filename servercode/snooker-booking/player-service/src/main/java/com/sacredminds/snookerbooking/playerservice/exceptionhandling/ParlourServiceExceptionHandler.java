package com.sacredminds.snookerbooking.playerservice.exceptionhandling;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sacredminds.snookerbooking.datamodel.Error;

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ControllerAdvice
public class ParlourServiceExceptionHandler extends ResponseEntityExceptionHandler {

	private final Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(value = ParlourServiceException.class)
	public ResponseEntity<ExceptionResult> handleBaseException(ParlourServiceException e) {

		slf4jLogger.error("Candidate Management exception occurred", e);
		ExceptionResult result = new ExceptionResult(e.getCode(), e.getMessage());
		if (e.getCode() == Error.NO_RECORDS.getCode()) {
			return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
		} else if (e.getCode() == Error.UNAUTHORISED.getCode()) {
			return new ResponseEntity<>(result, HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ExceptionHandler(value = { ConstraintViolationException.class })
	protected ResponseEntity<ExceptionResult> handleValidationErrors(Exception e) {
		ConstraintViolationException nevEx = (ConstraintViolationException) e;
		StringBuilder message = new StringBuilder();
		Set<ConstraintViolation<?>> violations = nevEx.getConstraintViolations();
		for (ConstraintViolation<?> violation : violations) {
			message.append(violation.getMessage().concat(";"));
		}
		String errorMessage = message.toString();
		ExceptionResult result = new ExceptionResult(HttpStatus.BAD_REQUEST.value(), errorMessage);
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionResult> handleConflict(Exception e) {
		slf4jLogger.error("Application has been encountered with runtime exception: ", e.getMessage());
		slf4jLogger.error("Runtime exception occurred", e);
		ExceptionResult result = new ExceptionResult(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Candidate Management service encountered runtime exception, please contact system administrator");
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		StringBuilder message = new StringBuilder();
		List<FieldError> errorList = ex.getBindingResult().getFieldErrors();
		for (FieldError error : errorList) {
			message.append(error.getField() + ": " + error.getDefaultMessage().concat(";"));
		}
		String errorMessage = message.toString();
		ExceptionResult result = new ExceptionResult(HttpStatus.BAD_REQUEST.value(), errorMessage);
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}

}
