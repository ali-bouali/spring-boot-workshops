package com.workshop.bouali.validators;

import com.workshop.bouali.dto.Greeting;
import com.workshop.bouali.exceptions.ObjectNotValidException;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

/**
 * @author Ali Bouali
 */
@Component
public class ObjectsValidator<T> {

  private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private final Validator validator = factory.getValidator();

  public void validate (T objectToValidate) {
    Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);
    if (!violations.isEmpty()) {
      var errorMessages = violations
          .stream()
          .map(ConstraintViolation::getMessage)
          .collect(Collectors.toSet());
      throw new ObjectNotValidException(errorMessages);
    }
  }
}
