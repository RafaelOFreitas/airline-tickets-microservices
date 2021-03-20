package br.com.airline.companhia.adapter.in.web.dto.view.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RotaViewOutput {

  private String origem;

  private String destino;

  private AeronaveViewOutput aeronave;
}