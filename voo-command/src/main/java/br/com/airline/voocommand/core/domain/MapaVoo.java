package br.com.airline.voocommand.core.domain;

import java.util.Map;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapaVoo {

  private Map<Classe, Set<Assento>> mapaAssentos;
}
