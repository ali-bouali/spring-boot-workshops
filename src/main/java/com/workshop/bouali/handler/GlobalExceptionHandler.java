package com.workshop.bouali.handler;

import com.workshop.bouali.exceptions.ObjectNotValidException;
import javax.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Ali Bouali
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(IllegalStateException.class)
  public ResponseEntity<?> handleException(IllegalStateException exception) {
    log.error(exception.getMessage());
    return ResponseEntity
        .badRequest()
        .body(exception.getMessage());
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<?> handleException() {
    return ResponseEntity
        .notFound()
        .build();
  }

  @ExceptionHandler(ObjectNotValidException.class)
  public ResponseEntity<?> handleException(ObjectNotValidException exp) {
    return ResponseEntity
        .badRequest()
        .body(exp.getErrorMessages());
  }

}
