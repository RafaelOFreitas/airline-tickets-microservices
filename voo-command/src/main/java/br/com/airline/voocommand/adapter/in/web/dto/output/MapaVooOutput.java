package br.com.airline.voocommand.adapter.in.web.dto.output;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapaVooOutput {

  private Set<SessaoVooOutput> sessoes;
}
