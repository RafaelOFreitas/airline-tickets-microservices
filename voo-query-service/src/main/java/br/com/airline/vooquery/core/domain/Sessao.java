package br.com.airline.vooquery.core.domain;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sessao {

  private Classe classe;
  private Set<Assento> assentos;

  public static Sessao mapaFactory(Classe classe, Integer filas, Integer qtdAssentos) {
    var assentos = Assento.builder().filas(filas).assentos(qtdAssentos).build();

    return new Sessao(classe, assentos);
  }
}
