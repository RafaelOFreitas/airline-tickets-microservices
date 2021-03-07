package br.com.airline.voocommand.core.domain;

import java.util.Objects;
import lombok.Getter;

@Getter
public enum Classe {

  EXECUTIVA(10), PRIMEIRA(20), ECONOMICA(70);

  private final int porcentagem;

  Classe(int porcentagem) {
    this.porcentagem = porcentagem;
  }

  public int arranjarFila(Integer filas) {
    if (Objects.nonNull(filas)) {
      return Math.toIntExact(Math.round((this.getPorcentagem() * filas) / 100.0));
    }

    return 0;
  }
}
