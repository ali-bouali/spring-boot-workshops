package com.workshop.bouali.controllers;

import com.workshop.bouali.dto.Greeting;
import com.workshop.bouali.services.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ali Bouali
 */
@RestController
@RequestMapping("/api/v1/greetings")
@RequiredArgsConstructor
public class GreetingController {

  private final GreetingService service;

  @PostMapping
  public ResponseEntity<String> postGreeting(
      @RequestBody Greeting greeting
  ) {
    final String greetingMsg = service.saveGreeting(greeting);
    return ResponseEntity
        .accepted()
        .body(greetingMsg);
  }

  @GetMapping("/error")
  public ResponseEntity<?> throwException() {
    return ResponseEntity.ok(service.throwException());
  }

}
