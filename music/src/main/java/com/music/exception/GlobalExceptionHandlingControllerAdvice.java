package com.music.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandlingControllerAdvice {

	// TODO: Class responsabilty by execptions globals

	public GlobalExceptionHandlingControllerAdvice() {
		log.info("Main Class exception!");
	}

	// @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resources not
	// found")
	// @ExceptionHandler(MusicExecption.class)
	// public void notFound() {
	// log.error("Log erro --> Resources not found
	// GlobalExceptionHandlingControllerAdvice");
	// }

}
