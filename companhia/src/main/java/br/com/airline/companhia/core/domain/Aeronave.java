package br.com.airline.companhia.core.domain;

import br.com.airline.companhia.core.domain.exception.NegocioException;
import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@NoArgsConstructor
@Getter
@Setter
public class Aeronave {

  private String matricula;
  private String modelo;
  private TipoAeronave tipo;
  private Set<Secao> secoes;
  private Status status;
  private OffsetDateTime dataRegistro;

  public void ativar() {
    this.validaSecao();
    this.status = Status.ATIVA;
  }

  public void inativar() {
    this.status = Status.INATIVA;
  }

  public void validaSecao() {
    if (this.tipo != TipoAeronave.EXECUTIVA) {
      return;
    }

    var invalida = this.secoes.stream()
        .anyMatch(s -> s.getClasse() == Classe.ECONOMICA || s.getClasse() == Classe.PRIMEIRA);

    if (invalida) {
      throw new NegocioException("Tipo de Aeronave não possui classe economica ou primeira classe");
    }
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
