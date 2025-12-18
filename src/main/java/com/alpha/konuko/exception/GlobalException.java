package com.alpha.konuko.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.konuko.ResponseStructure;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CarrierNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> CarrierNotFoundhandler()
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Carrier not found");
		rs.setData("Carrier not found");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}

}
