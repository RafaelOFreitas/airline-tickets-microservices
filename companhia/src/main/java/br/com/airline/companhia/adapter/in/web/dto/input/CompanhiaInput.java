package br.com.airline.companhia.adapter.in.web.dto.input;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanhiaInput {

  @NotBlank
  private String nome;

  @NotBlank
  private String cnpj;
}
