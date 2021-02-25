package br.com.airline.companhia.adapter.in.web.dto.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public class RotaOutput {

  @JsonProperty("id_rota")
  private Integer id;

  private String origem;

  private String destino;

  private List<AeronaveOutput> aeronaves;
}
