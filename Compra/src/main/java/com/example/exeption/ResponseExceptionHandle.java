package com.example.exeption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.dto.ErrorDto;






@Controller
@ControllerAdvice
@RestController
public class ResponseExceptionHandle extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ArgumentRequiredException.class)
	public final ResponseEntity<ErrorDto> ArgumentRequiredExceptionHandler (ArgumentRequiredException ex,
			WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.toString().intern(),ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.BAD_REQUEST);			
	}
	
	@ExceptionHandler(BusinessLogicException.class)
	public final ResponseEntity<ErrorDto> BusinessLogicExceptionHandler (BusinessLogicException ex,
			WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.toString().intern(),ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.BAD_REQUEST);			
	}
	
	@ExceptionHandler(ModelNotFoundException.class)
	public final ResponseEntity<ErrorDto> ModelNotFoundExceptionHandler (ModelNotFoundException ex,
			WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.toString().intern(),ex.getLocalizedMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.NOT_FOUND);			
	}
	

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDto>ExceptionHandler (Exception ex,
			WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.name(),  HttpStatus.INTERNAL_SERVER_ERROR.toString().intern(),  ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
	}
	
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<ErrorDto> ModelNullPointerException (NullPointerException ex,
			WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.name(), HttpStatus.INTERNAL_SERVER_ERROR.toString().intern(), ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ex.printStackTrace();
		ErrorDto error = new ErrorDto( HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.toString().intern() , ex.getBindingResult().getAllErrors().toString(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
		
		
	}

}
