package br.com.airline.voocommand.adapter.out.integration.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class RotaDto {

  private String origem;

  private String destino;

  private AeronaveDto aeronave;
}