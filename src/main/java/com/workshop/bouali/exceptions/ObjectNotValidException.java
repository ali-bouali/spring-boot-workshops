package com.workshop.bouali.exceptions;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author Ali Bouali
 */
@Data
public class ObjectNotValidException extends RuntimeException {

  private final Set<String> errorMessages;

}
