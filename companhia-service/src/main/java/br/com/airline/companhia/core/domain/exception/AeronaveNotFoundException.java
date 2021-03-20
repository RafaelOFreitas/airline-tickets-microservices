package br.com.airline.companhia.core.domain.exception;

import lombok.Getter;

@Getter
public class AeronaveNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public AeronaveNotFoundException(String matricula) {
    super(String.format("Aeronave não pode ser encontrada com a matricula: %s", matricula));
  }
}