package br.com.airline.voocommand.core.domain;

import java.util.EnumMap;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MapaVoo {

  private EnumMap<Classe, Set<Assento>> mapaAssentos;

  public static MapaVoo mapaFactory(Classe classe, Integer filas, Integer assentos) {
    EnumMap<Classe, Set<Assento>> mapa = new EnumMap<>(Classe.class);

    mapa.put(classe, Assento.builder()
        .filas(filas)
        .assentos(assentos)
        .build());

    return new MapaVoo(mapa);
  }
}
