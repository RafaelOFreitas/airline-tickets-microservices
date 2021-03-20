package br.com.airline.companhia.adapter.in.web.dto.input;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RotaInput {

  @NotBlank
  private String origem;

  @NotBlank
  private String destino;

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}