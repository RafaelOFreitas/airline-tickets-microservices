package br.com.airline.voocommand.core.domain;

import br.com.airline.voocommand.adapter.out.companhia.dto.TipoAeronaveDto;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MapaVoo {

  private EnumMap<Classe, Set<Assento>> mapaAssentos;

  public static Set<MapaVoo> mapaFactory(TipoAeronaveDto tipo, Integer filas, Integer assentos) {
    var mapas = new HashSet<MapaVoo>();

    if (TipoAeronaveDto.EXECUTIVA == tipo) {
      mapas.add(MapaVoo.mapaFactory(Classe.EXECUTIVA, filas, assentos));
      return mapas;
    }

    tipo.getClasses().forEach(c -> mapas.add(mapaFactory(c, c.arranjarFila(filas), assentos)));

    return mapas;
  }

  private static MapaVoo mapaFactory(Classe classe, Integer filas, Integer assentos) {
    EnumMap<Classe, Set<Assento>> mapa = new EnumMap<>(Classe.class);

    mapa.put(classe, Assento.builder()
        .filas(filas)
        .assentos(assentos)
        .build());

    return new MapaVoo(mapa);
  }
}
