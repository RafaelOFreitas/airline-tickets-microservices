package br.com.airline.voocommand.core.domain;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MapaVoo {

  private String id;
  private Set<Sessao> sessoes;
}
