package br.com.airline.voocommand.adapter.out.companhia.dto;

import br.com.airline.voocommand.core.domain.Classe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.Getter;

@Getter
public enum TipoAeronaveDto {
  COMERCIAL(Arrays.asList(Classe.EXECUTIVA, Classe.PRIMEIRA, Classe.ECONOMICA)),
  EXECUTIVA(Collections.singletonList(Classe.EXECUTIVA));

  private final List<Classe> classes;

  TipoAeronaveDto(List<Classe> classes) {
    this.classes = classes;
  }
}
