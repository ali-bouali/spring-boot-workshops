package com.workshop.bouali.services;

import com.workshop.bouali.dto.ExampleDto;
import com.workshop.bouali.dto.Greeting;
import com.workshop.bouali.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Ali Bouali
 */
@Service
@RequiredArgsConstructor
public class GreetingService {

  private final ObjectsValidator<Greeting> greetingValidator;
  private final ObjectsValidator<ExampleDto> exampleDtoValidator;
  public String saveGreeting(Greeting greeting) {
    greetingValidator.validate(greeting);
    final String greetingMsg =
        "Greeting message <<" +
            greeting.getMsg()
            + ">> from: " +
            greeting.getFrom().toUpperCase() +
            " to: " +
            greeting.getTo().toUpperCase();
    return greetingMsg;
  }

  /*
  throw Exception() <==> return
   */

  public String throwException() {
    throw new IllegalStateException("Some exception happened");
  }
}
