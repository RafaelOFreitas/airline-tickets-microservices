package br.com.airline.companhia.adapter.in.web.dto.input;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Getter
@Setter
public class CompanhiaInput {

  @NotBlank
  private String nome;

  @NotBlank
  private String cnpj;

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
