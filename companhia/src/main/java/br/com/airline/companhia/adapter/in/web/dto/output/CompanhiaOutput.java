package br.com.airline.companhia.adapter.in.web.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompanhiaOutput {

  @JsonProperty("id_companhia")
  private UUID id;

  private String nome;

  private String cnpj;

  private String status;
}
