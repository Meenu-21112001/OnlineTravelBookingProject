package com.travel.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler 
{

	@ExceptionHandler
	public ResponseEntity<AllExceptionDto> vvhjfhj(javax.persistence.EntityNotFoundException e)
	{
		
		System.out.println(" ------------- inside --- @Controller Advice Not Found Exception ----");
		
		AllExceptionDto dto = new AllExceptionDto();
		
		dto.setMsg(e.getLocalizedMessage());
		dto.setUserInput(e.getLocalizedMessage().toString());
		dto.setDateAndTime(LocalDateTime.now().toString());
		
		return new ResponseEntity<AllExceptionDto>(dto, HttpStatus.BAD_REQUEST);
	}
}