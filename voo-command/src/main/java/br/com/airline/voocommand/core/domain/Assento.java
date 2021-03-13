package br.com.airline.voocommand.core.domain;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Assento {

  private String codigo;
  private StatusAssento status;

  public static Builder builder() {
    return new Assento.Builder();
  }

  public static class Builder {

    private static final String ASSENTO_IDENTIFIER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Integer filas;
    private Integer assentos;

    public Builder filas(Integer filas) {
      this.filas = filas;
      return this;
    }

    public Builder assentos(Integer assentos) {
      this.assentos = assentos;
      return this;
    }

    public Set<Assento> build() {
      var assentosSet = new HashSet<Assento>();

      for (int fila = 1; fila <= this.filas; fila++) {
        for (int assento = 0; assento < this.assentos; assento++) {
          var codigo = this.getCodigoAssento(fila, assento);

          assentosSet.add(new Assento(codigo, StatusAssento.LIVRE));
        }
      }

      return assentosSet;
    }

    private String getCodigoAssento(Integer fila, Integer assento) {
      return String.valueOf(fila) + ASSENTO_IDENTIFIER.charAt(assento);
    }
  }
}
