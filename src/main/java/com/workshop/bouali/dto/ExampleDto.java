package com.workshop.bouali.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ali Bouali
 */
@Getter
@Setter
public class ExampleDto {

  @NotNull
  private String a;
  @NotNull
  private String b;
  @NotNull
  private String c;

}
