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

  private String numero;
  private StatusAssento statusAssento;

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
      var setAssentos = new HashSet<Assento>();

      for (int fila = 1; fila < this.filas; fila++) {
        for (int assento = 0; assento <= this.assentos; assento++) {
          var numero = this.getNumeroAssento(fila, assento);

          setAssentos.add(new Assento(numero, StatusAssento.LIVRE));
        }
      }

      return setAssentos;
    }

    private String getNumeroAssento(Integer fila, Integer assento) {
      return String.valueOf(fila) + ASSENTO_IDENTIFIER.indexOf(assento);
    }
  }
}
