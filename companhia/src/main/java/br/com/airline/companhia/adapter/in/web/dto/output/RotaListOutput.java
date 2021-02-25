package br.com.airline.companhia.adapter.in.web.dto.output;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RotaListOutput {

  private List<RotaOutput> rotas;
}
