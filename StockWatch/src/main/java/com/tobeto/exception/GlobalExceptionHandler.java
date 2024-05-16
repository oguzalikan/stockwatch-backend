package com.tobeto.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
//	private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
//			.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<GlobalExceptionDTO> error(Exception ex) {
		log.error(ex);
		GlobalExceptionDTO dto = new GlobalExceptionDTO();
		dto.setCode(1001);
		dto.setMesaj("Hata oluştu");
		return ResponseEntity.internalServerError().body(dto);
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<GlobalExceptionDTO> serviceException(ServiceException ex) {
		log.error(ex);
		GlobalExceptionDTO dto = new GlobalExceptionDTO();
		dto.setCode(ex.getCode());
		dto.setMesaj(ex.getMessage());
		return ResponseEntity.internalServerError().body(dto);
	}
}
