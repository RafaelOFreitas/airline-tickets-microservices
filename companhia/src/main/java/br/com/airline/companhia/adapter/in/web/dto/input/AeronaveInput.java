package br.com.airline.companhia.adapter.in.web.dto.input;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AeronaveInput {

  @NotBlank
  private String matricula;

  @NotBlank
  private String modelo;

  @NotNull
  private TipoAeronaveInput tipo;

  @NotNull
  private Set<SecaoInput> secoes;

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
