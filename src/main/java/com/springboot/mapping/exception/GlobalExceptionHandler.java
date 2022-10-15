package com.springboot.mapping.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The Class GlobalExceptionHandler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Custom exception handle.
	 *
	 * @param ex      the exception
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> customExceptionHandle(CustomException ex, WebRequest request) {

		ErrorResponse response = new ErrorResponse();
		response.setStatusCode(ex.getStatus().value());
		response.setSuccessMessage(ex.getStatus().name());
		response.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(response, ex.getStatus());

	}

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
//		Map<String, String> errorMap = new HashMap<>();
//		ex.getBindingResult().getFieldErrors().forEach(error -> {
//			errorMap.put(error.getField(), error.getDefaultMessage());
//		});
//		return errorMap;
//	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return new ResponseEntity<>(errorMap, status);
	}
}
